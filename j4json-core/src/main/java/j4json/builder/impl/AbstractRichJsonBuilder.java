package j4json.builder.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import j4json.IndentedJsonSerializable;
import j4json.builder.FlexibleJsonBuilder;
import j4json.builder.JsonBuilderException;
import j4json.builder.RichJsonBuilder;
import j4json.builder.policy.BuilderPolicy;
import j4json.type.JsonArrayNode;
import j4json.type.JsonNode;
import j4json.type.JsonObjectNode;
import j4json.type.base.AbstractJsonArrayNode;
import j4json.type.base.AbstractJsonObjectNode;



// work in progress....
// Not implemented. 
// Do not use this class.
/* public */  abstract class AbstractRichJsonBuilder implements RichJsonBuilder, FlexibleJsonBuilder
{
    private static final Logger log = Logger.getLogger(AbstractRichJsonBuilder.class.getName());

    
    // TBD:
    // "print/format type" ???
    // e.g., compact, normal, indented, etc.
    // ...
    
    // "strategy" for building json structure.
    private BuilderPolicy builderPolicy = null;
    

    public AbstractRichJsonBuilder()
    {
    }


    @Override
    public BuilderPolicy getBuilderPolicy()
    {
        return this.builderPolicy;
    }
    public void setBuilderPolicy(BuilderPolicy builderPolicy)
    {
        this.builderPolicy = builderPolicy;
    }


    @Override
    public String build(Object jsonObj) throws JsonBuilderException
    {
        if(jsonObj instanceof JsonNode) {
            return _build((JsonNode) jsonObj);
        } else {
            return _build(jsonObj, 0);
        }
    }
    @Override
    public String build(Object jsonObj, int indent) throws JsonBuilderException
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String buildJson(JsonNode node) throws JsonBuilderException
    {
        return _build(node);
    }
    @Override
    public String buildJson(JsonNode node, int indent) throws JsonBuilderException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void buildJson(Writer writer, JsonNode node) throws IOException, JsonBuilderException
    {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void buildJson(Writer writer, JsonNode node, int indent)
            throws IOException, JsonBuilderException
    {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void build(Writer writer, Object jsonObj) throws IOException, JsonBuilderException
    {
        // TBD:
    }
    @Override
    public void build(Writer writer, Object jsonObj, int indent) throws IOException, JsonBuilderException
    {
        // TBD:
    }


    @Override
    public Object buildJsonStructure(Object jsonObj)
            throws JsonBuilderException
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Object buildJsonStructure(Object jsonObj, int depth)
            throws JsonBuilderException
    {
        // TODO Auto-generated method stub
        return null;
    }

    
    
    // The following does not make sense...
    private String _build(Object node, int indent) throws JsonBuilderException
    {
        if(node == null) {
            return null;
        } 
        String jsonStr;
        if(node instanceof Map<?,?>) {
            JsonObjectNode jo = new AbstractJsonObjectNode((Map<String,Object>) ((Map<?,?>) node));
            jsonStr = buildJson(jo);
        } else if(node instanceof List<?>) {
            JsonArrayNode ja = new AbstractJsonArrayNode((List<Object>) ((List<?>) node));
            jsonStr = buildJson(ja);
        } else if(node.getClass().isArray()) {
            JsonArrayNode ja = new AbstractJsonArrayNode(Arrays.asList(node));
            jsonStr = buildJson(ja);
        } else {
            // ???
            if(node instanceof IndentedJsonSerializable) {
                jsonStr = ((IndentedJsonSerializable) node).toJsonString();
            } else {
                // ????
                jsonStr = node.toString();
            }
        }
        return jsonStr;
    }

    private String _build(JsonNode node) throws JsonBuilderException
    {
        String jStr = node.toJsonString();
        return jStr;
    }


    
}
