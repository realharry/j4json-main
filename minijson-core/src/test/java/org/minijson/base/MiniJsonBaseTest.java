package org.minijson.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.JsonAny;
import org.minijson.base.MiniJsonBase;
import org.minijson.builder.JsonBuilderException;
import org.minijson.builder.impl.AbstractBareJsonBuilder;
import org.minijson.builder.policy.base.DefaultBuilderPolicy;

public class MiniJsonBaseTest
{
    public static final class TestMiniJsonBase extends MiniJsonBase
    {
        Map<String,Object> map;
        
        public Map<String,Object> getMap()
        {
            return map;
        }

        @Override
        protected void init()
        {
            map = new HashMap<String,Object>();
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
        }

    }

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
        // TestMiniJsonBase jsonAny = new TestMiniJsonBase();
        
        MiniJsonBase jsonAny = new MiniJsonBase() {
            Map<String,Object> map;
            
            public Map<String,Object> getMap()
            {
                return map;
            }

            @Override
            protected void init()
            {
                map = new HashMap<String,Object>();
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
            }

        };
       
        
        
        String jsonStr = null;
        try {
            jsonStr = jsonAny.toJsonString();
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);

    }


    @Test
    public void testToJsonStructure1()
    {
        JsonAny jsonAny = new MiniJsonBase() {
            Map<String,Object> map;
            
            public Map<String,Object> getMap()
            {
                return map;
            }

            @Override
            protected void init()
            {
                map = new HashMap<String,Object>();
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
            }

        };
        
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


}
