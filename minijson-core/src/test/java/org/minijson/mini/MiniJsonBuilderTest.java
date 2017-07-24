package org.minijson.mini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.builder.IndentedJsonBuilder;
import org.minijson.builder.JsonBuilderException;


public class MiniJsonBuilderTest
{
    private IndentedJsonBuilder jsonBuilder;

    @Before
    public void setUp() throws Exception
    {
        jsonBuilder = new MiniJsonBuilder();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testBuild1()
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

        Object obj = map;
        String jsonStr = null;
        try {
            jsonStr = jsonBuilder.build(obj, 4);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);
    }

    @Test
    public void testBuild2()
    {
        List<Object> list = new ArrayList<Object>();
        list.add("a");
        
        Object obj = list;
        String jsonStr = null;
        try {
            jsonStr = jsonBuilder.build(obj);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);
    }

}
