package j4json.ext.template.fm.gen;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import j4json.IndentedJsonSerializable;
import j4json.JsonCompatible;
import j4json.JsonSerializable;
import j4json.builder.JsonBuilderException;
import j4json.builder.core.IndentInfoStruct;
import j4json.builder.policy.BuilderPolicy;
import j4json.builder.policy.base.DefaultBuilderPolicy;
import j4json.builder.util.BeanIntrospectionUtil;
import j4json.common.JsonNull;
import j4json.common.Literals;
import j4json.common.Symbols;
import j4json.ext.template.JsonTemplateGenerator;
import j4json.util.CharacterUtil;
import j4json.util.UnicodeUtil;


public class FreeMarkerTemplateGenerator implements JsonTemplateGenerator
{
    private static final Logger log = Logger.getLogger(FreeMarkerTemplateGenerator.class.getName());

    // Default value.
    // private static final int DEF_DRILL_DOWN_DEPTH = 1;
    // Max value: equivalent to -1.
    private static final int MAX_DRILL_DOWN_DEPTH = (int) Byte.MAX_VALUE;  // Arbitrary.

    // "strategy" for building json structure.
    private BuilderPolicy builderPolicy = null;


    public FreeMarkerTemplateGenerator()
    {
        builderPolicy = DefaultBuilderPolicy.MINIJSON;
    }

    public BuilderPolicy getBuilderPolicy()
    {
        return this.builderPolicy;
    }
    public void setBuilderPolicy(BuilderPolicy builderPolicy)
    {
        this.builderPolicy = builderPolicy;
    }

    
    
    @Override
    public String generate(Object object) throws JsonBuilderException
    {
        return generate(object, 0);
    }

    @Override
    public String generate(Object object, int indent) throws JsonBuilderException
    {
        int maxDepth = builderPolicy.drillDownDepth();
        if(maxDepth < 0) {
            maxDepth = MAX_DRILL_DOWN_DEPTH;
        }
        boolean useBeanIntrospection = this.builderPolicy.useBeanIntrospection();
        
        IndentInfoStruct indentInfo = new IndentInfoStruct(indent);
        boolean includeWS = indentInfo.isIncludingWhiteSpaces();
        boolean includeLB = indentInfo.isIncludingLineBreaks();
        boolean lbAfterComma = indentInfo.isLineBreakingAfterComma();
        int indentSize = indentInfo.getIndentSize();
        int indentLevel = -1;

        StringBuilder sb = new StringBuilder();
        _generate(sb, object, maxDepth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);
        
        return sb.toString();
    }
    
    
    // TBD:
    // This is just copied from JsonBuilder implementation
    // Need to replace all "values" with FreeMarker variables...
    // ....

    private void _generate(StringBuilder sb, Object obj, int depth, boolean useBeanIntrospection, boolean includeWS, boolean includeLB, boolean lbAfterComma, int indentSize, int indentLevel) throws JsonBuilderException
    {
        if(depth < 0) {
            return;
        }

        // TBD:
        // Just use global vars ???
        ++indentLevel;
        String WS = "";
        if(includeWS) {
            WS = " ";
        }
        String LB = "";
        if(includeLB) {
            LB = "\n";
        }
        String IND = "";
        String INDX = "";
        if(indentSize > 0 && indentLevel > 0) {
            IND = String.format("%1$" + (indentSize * indentLevel) + "s", "");
        }
        if(indentSize > 0 && indentLevel >= 0) {
            INDX = String.format("%1$" + (indentSize * (indentLevel+1)) + "s", "");
        }
        
        // StringBuilder sb = new StringBuilder();
        if(obj == null || obj instanceof JsonNull) {
            sb.append(Literals.NULL);
        } else {
            // if(depth == 0) {
            if(depth <= 0) {
                if(obj instanceof JsonSerializable) { 
                    String jSerial = null;
                    if(obj instanceof IndentedJsonSerializable) {
                        jSerial = ((IndentedJsonSerializable) obj).toJsonString(indentSize);
                    } else {
                        jSerial = ((JsonSerializable) obj).toJsonString();
                    }
                    sb.append(jSerial);
                } else {
                    // TBD:
                    // This section of code is repeated when depth==0 and and when depth>0,
                    //     almost identically... (but not quite exactly the same)
                    // Need to be refactored.
                    // ....
                    String primStr = null;
                    if(obj instanceof Boolean) {
                        if(((Boolean) obj).equals(Boolean.TRUE)) {
                            primStr = Literals.TRUE;
                        } else {
                            primStr = Literals.FALSE;
                        }                        
                        sb.append(primStr);
                    } else if (obj instanceof Character) {
                        // ???
                        Character strChar = (Character) obj;
                        sb.append("\"").append(strChar).append("\"");
                    } else if (obj instanceof Number) {
//                        double d = ((Number) obj).doubleValue();
//                        jsonStr = Double.valueOf(d);
                        primStr = ((Number) obj).toString();
                        sb.append(primStr);
                    } else if(obj instanceof String) {
                        // ????
                        // Is there a better/faster way to do this?

                        // ???
                        primStr = (String) obj;
                        // sb.append("\"").append(primStr).append("\"");

                        // ???
                        int escapeForwardSlash = builderPolicy.escapeForwardSlash();
                        sb.append("\"");
                        if(primStr != null && !primStr.isEmpty()) {
                            char[] primChars = primStr.toCharArray();
                            char prevEc = 0;
                            for(char ec : primChars) {
                                if(Symbols.isEscapedChar(ec)) {
                                    if(prevEc == '<' && ec == '/') {
                                        if(escapeForwardSlash >= 0) {
                                            sb.append("\\/");
                                        } else {
                                            sb.append("/");
                                        }
                                    } else {
                                        String str = Symbols.getEscapedCharString(ec, escapeForwardSlash > 0 ? true : false);
                                        if(str != null) {
                                            sb.append(str);
                                        } else {
                                            // ???
                                            sb.append(ec);
                                        }
                                    }
                                } else if(CharacterUtil.isISOControl(ec)) {
                                    char[] uc = UnicodeUtil.getUnicodeHexCodeFromChar(ec);
                                    sb.append(uc);
                                } else { 
                                    sb.append(ec);
                                }
                                prevEc = ec;
                            }
                        }
                        sb.append("\"");
                        // ???
                        
                    } else {
                        
                        // TBD:
                        // java.util.Date ???
                        // and other JDK built-in class support???
                        // ..

                        if(obj instanceof Date) {
                            // TBD:
                            // Create a struct ???
                            primStr = ((Date) obj).toString();
                            // ...
                        } else if(obj instanceof String) {
                            primStr = (String) obj;
                        } else {
                            
                            // TBD:
                            // POJO/Bean support???
                            // ...
                            
                            // ????
                            primStr = obj.toString();
                        }
                        sb.append("\"").append(primStr).append("\"");
                    }
                }
            } else {

                if(obj instanceof Map<?,?>) {
                    Map<String,Object> map = null;
                    try {
                        map = (Map<String,Object>) ((Map<?,?>) obj);
                    } catch(Exception e) {
                        log.log(Level.INFO, "Invalid map type.", e);
                    }
                    sb.append("{").append(LB);
                    if(map != null && !map.isEmpty()) {
                        sb.append(INDX);
                        
                        Iterator<String> it = map.keySet().iterator();
                        while(it.hasNext()) {
                            String key = it.next();
                            Object val = map.get(key);
                            sb.append("\"").append(key).append("\":").append(WS);
                            _generate(sb, val, depth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);
                            // sb.append("\"").append(key).append("\":").append(WS).append(str);
                            if(it.hasNext()) {
                                sb.append(",");
                                if(lbAfterComma) {
                                    sb.append(LB).append(INDX);
                                } else {
                                    sb.append(WS);
                                }
                            } else {
                                sb.append(LB);
                            }
                        }
                    }
                    sb.append(IND).append("}");
                } else if(obj instanceof List<?>) {
                    List<Object> list = null;
                    try {
                        list = (List<Object>) ((List<?>) obj);
                    } catch(Exception e) {
                        log.log(Level.INFO, "Invalid list type.", e);
                    }
                    sb.append("[").append(LB);
                    if(list != null && !list.isEmpty()) {
                        sb.append(INDX);
                        
                        Iterator<Object> it = list.iterator();
                        while(it.hasNext()) {
                            Object o = it.next();
                            _generate(sb, o, depth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);
                            // sb.append(str);
                            if(it.hasNext()) {
                                sb.append(",");
                                if(lbAfterComma) {
                                    sb.append(LB).append(INDX);
                                } else {
                                    sb.append(WS);
                                }
                            } else {
                                sb.append(LB);
                            }
                        }
    //                    for(Object o : list) {
    //                        String str = _build(o, includeWS, includeLB, indentSize, indentLevel);
    //                        sb.append(str);
    //                        sb.append(",").append(WS);
    //                    }
    //                    if(sb.charAt(sb.length() - 1) == ',' || sb.charAt(sb.length() - 1) == ' ') {
    //                        sb.deleteCharAt(sb.length() - 1);
    //                        if(sb.charAt(sb.length() - 1) == ',') {
    //                            sb.deleteCharAt(sb.length() - 1);
    //                        }
    //                    }
                    }
                    sb.append(IND).append("]");
                } else if(obj.getClass().isArray()) {          // ???
                    Object[] array = null;
                    try {
                        array = (Object[]) obj;
                    } catch(Exception e) {
                        log.log(Level.INFO, "Invalid array type.", e);
                    }
                    // ???
                    _generate(sb, Arrays.asList(array), depth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);
                    // sb.append(strArr);
    //                sb.append("[").append(LB);
    //                if(array!= null && array.length > 0) {
    //                    sb.append(INDX);
    //                    for(Object o : array) {
    //                        String str = _build(o, includeWS, includeLB, indentSize, indentLevel);
    //                        sb.append(str);
    //                        sb.append(",").append(WS);
    //                    }
    //                    if(sb.charAt(sb.length() - 1) == ',' || sb.charAt(sb.length() - 1) == ' ') {
    //                        sb.deleteCharAt(sb.length() - 1);
    //                        if(sb.charAt(sb.length() - 1) == ',') {
    //                            sb.deleteCharAt(sb.length() - 1);
    //                        }
    //                    }
    //                }
    //                sb.append(LB).append(IND).append("]");
                } else if(obj instanceof Collection<?>) {       // ???????
                    Collection<Object> coll = null;
                    try {
                        coll = (Collection<Object>) ((Collection<?>) obj);
                    } catch(Exception e) {
                        log.log(Level.INFO, "Invalid collection type.", e);
                    }
                    sb.append("[").append(LB);
                    if(coll != null && !coll.isEmpty()) {
                        sb.append(INDX);
                    
                        Iterator<Object> it = coll.iterator();
                        while(it.hasNext()) {
                            Object o = it.next();
                            _generate(sb, o, depth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);
                            // sb.append(str);
                            if(it.hasNext()) {
                                sb.append(",");
                                if(lbAfterComma) {
                                    sb.append(LB).append(INDX);
                                } else {
                                    sb.append(WS);
                                }
                            } else {
                                sb.append(LB);
                            }
                        }
                    }
                    sb.append(IND).append("]");
                } else {
                    // ???
                    // TBD: indentSize, etc. ????
                    if(obj instanceof JsonSerializable) {
                        String jSerial = null;
                        if(obj instanceof IndentedJsonSerializable) {
                            jSerial = ((IndentedJsonSerializable) obj).toJsonString(indentSize);
                        } else {
                            jSerial = ((JsonSerializable) obj).toJsonString();
                        }
                        sb.append(jSerial);
                    // Note: this is better than JsonSerializable since it obeys the indentLevel rule, etc. 
                    // But, it seems more reasonable to use JsonSerializable first if the object implements both interfaces.
                    } else if(obj instanceof JsonCompatible) {
                        // ????
                        Object jObj = null;
                        try {
                            jObj = ((JsonCompatible) obj).toJsonStructure();
                            // Use this.toJsonStructure(jObj) ???
                            // ...
                        } catch (JsonBuilderException e) {
                            // Ignore
                            log.log(Level.WARNING, "Failed to create JSON struct for a JsonCompatible object.", e);
                        }
                        if(jObj != null) {
                            _generate(sb, jObj, depth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);
                        } else {
                            // ???
                            String jcStr = obj.toString();
                            sb.append("\"").append(jcStr).append("\"");
                        }
                    } else {
                        // primitive types... ???
                        // ...
                        String primStr = null;
                        if(obj instanceof Boolean) {
                            if(((Boolean) obj).equals(Boolean.TRUE)) {
                                primStr = Literals.TRUE;
                            } else {
                                primStr = Literals.FALSE;
                            }                        
                            sb.append(primStr);
                        } else if (obj instanceof Character) {
                            // ???
                            Character strChar = (Character) obj;
                            sb.append("\"").append(strChar).append("\"");
                        } else if (obj instanceof Number) {
    //                        double d = ((Number) obj).doubleValue();
    //                        jsonStr = Double.valueOf(d);
                            primStr = ((Number) obj).toString();
                            sb.append(primStr);
                        } else if(obj instanceof String) {
                            // ????
                            // Is there a better/faster way to do this?
    
                            // ???
                            primStr = (String) obj;
                            // sb.append("\"").append(primStr).append("\"");
    
                            // ???
                            int escapeForwardSlash = builderPolicy.escapeForwardSlash();
                            sb.append("\"");
                            if(primStr != null && !primStr.isEmpty()) {
                                char[] primChars = primStr.toCharArray();
                                char prevEc = 0;
                                for(char ec : primChars) {
                                    if(Symbols.isEscapedChar(ec)) {
                                        if(prevEc == '<' && ec == '/') {
                                            if(escapeForwardSlash >= 0) {
                                                sb.append("\\/");
                                            } else {
                                                sb.append("/");
                                            }
                                        } else {
                                            String str = Symbols.getEscapedCharString(ec, escapeForwardSlash > 0 ? true : false);
                                            if(str != null) {
                                                sb.append(str);
                                            } else {
                                                // ???
                                                sb.append(ec);
                                            }
                                        }
                                    } else if(CharacterUtil.isISOControl(ec)) {
                                        char[] uc = UnicodeUtil.getUnicodeHexCodeFromChar(ec);
                                        sb.append(uc);
                                    } else { 
                                        sb.append(ec);
                                    }
                                    prevEc = ec;
                                }
                            }
                            sb.append("\"");
                            // ???
                            
                        } else {
                            
                            // TBD:
                            // java.util.Date ???
                            // and other JDK built-in class support???
                            // ..
    
                            if(obj instanceof Date) {
                                // TBD:
                                // Create a struct ???
                                primStr = ((Date) obj).toString();
                                // ...
                            } else if(obj instanceof String) {
                                primStr = (String) obj;
                            } else {
                                

                                if(useBeanIntrospection) {
                                    Map<String, Object> mapEquivalent = null;
                                    try {
                                        // mapEquivalent = BeanIntrospectionUtil.introspect(obj, depth);   // depth? or depth - 1 ?
                                        // Because we are just converting a bean to a map,
                                        // the depth param is not used. (or, depth == 1).
                                        mapEquivalent = BeanIntrospectionUtil.introspect(obj);
                                    // } catch (IllegalAccessException
                                    //         | IllegalArgumentException
                                    //         | InvocationTargetException
                                    //         | IntrospectionException e) {
                                    } catch (Exception e) {
                                        // Ignore.
                                        if(log.isLoggable(Level.INFO)) log.log(Level.INFO, "Faild to introspect a bean.", e);
                                    }
                                    if(mapEquivalent != null) {
                                        _generate(sb, mapEquivalent, depth, useBeanIntrospection, includeWS, includeLB, lbAfterComma, indentSize, indentLevel);  // Note: We do not change the depth.
                                    } else {
                                        
                                        // ????
                                        // primStr = null; ???
                                        primStr = obj.toString();
                                        // ...
                                    }

                                } else {
                                    
                                    // ????
                                    primStr = obj.toString();
                                }

                            }
                            sb.append("\"").append(primStr).append("\"");
                        }
                    }
                }
            }
        }
        
    }
    
    
}
