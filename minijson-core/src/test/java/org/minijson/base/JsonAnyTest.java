package org.minijson.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.JsonAny;
import org.minijson.base.MiniJsonWrapper;
import org.minijson.builder.JsonBuilderException;
import org.minijson.builder.impl.AbstractBareJsonBuilder;
import org.minijson.builder.policy.base.DefaultBuilderPolicy;

public class JsonAnyTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testToJsonString()
    {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Object> list1 = new ArrayList<Object>();
        list1.add("x");
        list1.add("y");
        list1.add("z");
        map.put("a", list1);
        map.put("b", false);
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("p", 100);
        map2.put("q", null);
        map2.put("r", 200);
        map.put("c", map2);
        
        Boolean b = true;
        
        Object jsonObj = map;
        // Object jsonObj = b;

        JsonAny jsonAny = new MiniJsonWrapper(jsonObj) {};
        
        String jsonStr = null;
        try {
            jsonStr = jsonAny.toJsonString();
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);

    }

    @Test
    public void testToObject()
    {
        try {
            MiniJsonWrapper jsonAny = null;
            
//            String jsonStr1 = "abc";
//            jsonAny = new MiniJsonBase(jsonStr1) {};
//            Object obj1 = jsonAny.toJsonStructure();
//            System.out.println("obj1 = " + obj1);
    
            String jsonStr1a = "\"xyz\"";
            jsonAny = new MiniJsonWrapper(jsonStr1a) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj1a = jsonAny.toJsonStructure();
            System.out.println("obj1a = " + obj1a + " -- " + ((obj1a != null) ? obj1a.getClass() : ""));
    
            String jsonStr2 = "null";
            jsonAny = new MiniJsonWrapper(jsonStr2) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj2 = jsonAny.toJsonStructure();
            System.out.println("obj2 = " + obj2);
    
            String jsonStr3 = "false";
            jsonAny = new MiniJsonWrapper(jsonStr3) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj3 = jsonAny.toJsonStructure();
            System.out.println("obj3 = " + obj3 + " -- " + ((obj3 != null) ? obj3.getClass() : ""));
    
            String jsonStr4 = "4";
            jsonAny = new MiniJsonWrapper(jsonStr4) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj4 = jsonAny.toJsonStructure();
            System.out.println("obj4 = " + obj4 + " -- " + ((obj4 != null) ? obj4.getClass() : ""));
    
            String jsonStr5 = "[3, 5, 7]";
            jsonAny = new MiniJsonWrapper(jsonStr5) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj5 = jsonAny.toJsonStructure();
            System.out.println("obj5 = " + obj5 + " -- " + ((obj5 != null) ? obj5.getClass() : ""));
    
            String jsonStr6 = "{\"a\":[3, 5, 7]}";
            jsonAny = new MiniJsonWrapper(jsonStr6) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj6 = jsonAny.toJsonStructure();
            System.out.println("obj6 = " + obj6 + " -- " + ((obj6 != null) ? obj6.getClass() : ""));
    
            String jsonStr7 = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";
            jsonAny = new MiniJsonWrapper(jsonStr7) {};
            System.out.println("jsonAny = " + jsonAny);
            Object obj7 = jsonAny.toJsonStructure();
            System.out.println("obj7 = " + obj7 + " -- " + ((obj7 != null) ? obj7.getClass() : ""));
        
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToJsonStructure1()
    {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Object> list1 = new ArrayList<Object>();
        list1.add("x");
        list1.add("y");
        list1.add("z");
        map.put("a", list1);
        map.put("b", false);
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("p", 100);
        map2.put("q", null);
        map2.put("r", 200);
        map.put("c", map2);
        
        Boolean b = true;
        
        Object obj = map;
        // Object jsonObj = b;

        JsonAny jsonAny = new MiniJsonWrapper(obj) {};
        
        // String jsonStr = jsonAny.toJsonString();
        // System.out.println("jsonStr = " + jsonStr);
        
        Object jsonObj = null;
        try {
            jsonObj = jsonAny.toJsonStructure(3);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        
        // For tracing
        AbstractBareJsonBuilder bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.BEANDRILLDOWN) {};
        // bareJsonBuilder.setBuilderPolicy(DefaultBuilderPolicy.BEANDRILLDOWN);
        String jsonStr = null;
        try {
            jsonStr = bareJsonBuilder.build(jsonObj, 4);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);

    }

    @Test
    public void testToJsonStructure2()
    {
        try {
            // For tracing
            AbstractBareJsonBuilder bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.BEANDRILLDOWN) {};
            // bareJsonBuilder.setBuilderPolicy(DefaultBuilderPolicy.BEANDRILLDOWN);
    
            MiniJsonWrapper jsonAny = null;
    
            String jsonStr1a = "\"xyz\"";
            // String jsonStr1a = "\"x\"";
            // String jsonStr1a = "\"\\u12\"";  // this should throw exception.
            // String jsonStr1a = "\"\\u0032a\"";
            jsonAny = new MiniJsonWrapper(jsonStr1a) {};
            // System.out.println("jsonAny = " + jsonAny);
            // Object obj1 = jsonAny.toObject();
            // System.out.println("obj1 = " + obj1 + " -- " + obj1.getClass());
            Object obj1a = null;
            try {
                obj1a = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            System.out.println("obj1a = " + obj1a + " -- " + ((obj1a != null) ? obj1a.getClass() : ""));
            String jsonStr1b = bareJsonBuilder.build(obj1a, 4);
            System.out.println("jsonStr1b = " + jsonStr1b);
    
            String jsonStr2 = "null";
            jsonAny = new MiniJsonWrapper(jsonStr2) {};
    //        System.out.println("jsonAny = " + jsonAny);
    //        Object obj222 = jsonAny.toObject();
    //        System.out.println("obj222 = " + obj222 + " -- " + obj222.getClass());
            Object obj2 = null;
            try {
                obj2 = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            // System.out.println("obj2 = " + obj2 + " -- " + obj2.getClass());
            String jsonStr2b = bareJsonBuilder.build(obj2, 4);
            System.out.println("jsonStr2b = " + jsonStr2b);
    
            String jsonStr3 = "false";
            jsonAny = new MiniJsonWrapper(jsonStr3) {};
            Object obj3 = null;
            try {
                obj3 = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            System.out.println("obj3 = " + obj3 + " -- " + ((obj3 != null) ? obj3.getClass() : ""));
            String jsonStr3b = bareJsonBuilder.build(obj3, 4);
            System.out.println("jsonStr3b = " + jsonStr3b);
    
            String jsonStr4 = "4";
            jsonAny = new MiniJsonWrapper(jsonStr4) {};
            Object obj4 = null;
            try {
                obj4 = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            System.out.println("obj4 = " + obj4 + " -- " + ((obj4 != null) ? obj4.getClass() : ""));
            String jsonStr4b = bareJsonBuilder.build(obj4, 4);
            System.out.println("jsonStr4b = " + jsonStr4b);
    
            String jsonStr5 = "[3, 5, 7]";
            jsonAny = new MiniJsonWrapper(jsonStr5) {};
            Object obj5 = null;
            try {
                obj5 = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            System.out.println("obj5 = " + obj5 + " -- " + ((obj5 != null) ? obj5.getClass() : ""));
            String jsonStr5b = bareJsonBuilder.build(obj5, 4);
            System.out.println("jsonStr5b = " + jsonStr5b);
    
            String jsonStr6 = "{\"a\":[3, 5, 7, null]}";
            jsonAny = new MiniJsonWrapper(jsonStr6) {};
            Object obj6 = null;
            try {
                obj6 = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            System.out.println("obj6 = " + obj6 + " -- " + ((obj6 != null) ? obj6.getClass() : ""));
            String jsonStr6b = bareJsonBuilder.build(obj6, 4);
            System.out.println("jsonStr6b = " + jsonStr6b);
    
            String jsonStr7 = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";
            jsonAny = new MiniJsonWrapper(jsonStr7) {};
            Object obj7 = null;
            try {
                obj7 = jsonAny.toJsonStructure(2);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
            System.out.println("obj7 = " + obj7 + " -- " + ((obj7 != null) ? obj7.getClass() : ""));
            String jsonStr7b = bareJsonBuilder.build(obj7, 4);
            System.out.println("jsonStr7b = " + jsonStr7b);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }

}
