package org.minijson.builder.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.builder.BareJsonBuilder;
import org.minijson.builder.JsonBuilderException;
import org.minijson.builder.policy.base.DefaultBuilderPolicy;

public class AbstractBareJsonBuilderTest
{
    private BareJsonBuilder bareJsonBuilder;

    @Before
    public void setUp() throws Exception
    {
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.SIMPLE) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.RPCOBJECT) {};
        bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.MINIJSON) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.BEANDRILLDOWN) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.MAPANDLISTS) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.ESCAPESLASH) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.NOESCAPESLASH) {};
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.SIMPLE);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.RPCOBJECT);
//        ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.MINIJSON);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.BEANDRILLDOWN);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.MAPANDLISTS);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.ESCAPESLASH);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.NOESCAPESLASH);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testBuild1()
    {
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        List<Object> list1 = new ArrayList<Object>();
        list1.add("x");
        list1.add("y");
        list1.add("z");
        map.put("a", list1);
        map.put("b", false);
        Map<String,Object> map2 = new LinkedHashMap<String,Object>();
        map2.put("p", 100);
        map2.put("q", null);
        map2.put("r", 200);
        map.put("c", map2);

        Object obj = map;
        // String jsonStr = bareJsonBuilder.build(obj, 2);
        String jsonStr = null;
        try {
            jsonStr = bareJsonBuilder.build(obj, 4);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("[1] jsonStr = " + jsonStr);
    }

    @Test
    public void testBuild2()
    {
        List<Object> list = new ArrayList<Object>();
        list.add("a");
        
        Object obj = list;
        String jsonStr = null;
        try {
            jsonStr = bareJsonBuilder.build(obj);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("[2] jsonStr = " + jsonStr);
    }

    @Test
    public void testBuild3()
    {
        Object objA = new Character[]{'X', 'Y', 'Z'};
        String jsonStrA = null;
        try {
            jsonStrA = bareJsonBuilder.build(objA);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("[3a] jsonStrA = " + jsonStrA);

        Object objB = new byte[]{3,5,7};
        String jsonStrB = null;
        try {
            jsonStrB = bareJsonBuilder.build(objB);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("[3b] jsonStrB = " + jsonStrB);
    }

    @Test
    public void testToJsonStructure()
    {
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        List<Object> list1 = new ArrayList<Object>();
        list1.add("x");
        list1.add("y\ny\ty\ry\\y ___ \\/ / ___ </ ___ y/y\"\u0033\u0035y\u001ay");
        list1.add("z");
        list1.add(null);
        map.put("a", list1);
        TestJsonCompatibleObject jb1 = new TestJsonCompatibleObject();
        map.put("a2", jb1);
        TestJsonCompatibleArray jb2 = new TestJsonCompatibleArray();
        map.put("a3", jb2);
        map.put("b", false);
        Map<String,Object> map2 = new LinkedHashMap<String,Object>();
        map2.put("p", 100);
        map2.put("q", null);
        map2.put("r", 200);
        map2.put("s", Byte.MAX_VALUE);
        map2.put("t", new Byte[]{});
        map2.put("u", new Byte[]{Byte.MIN_VALUE});

        map.put("b2", null);
        map.put("c", map2);
        map.put("c2", map2);

        TestBean bean1 = new TestBean(3, "aaaa");
        bean1.setAttrF(new char[]{'h','i'});
        Map<String,Object> mapC1 = new LinkedHashMap<String,Object>();
        mapC1.put("ii", 33);
        TestBean beanC1 = new TestBean(4, "bbbb");
        TestBean beanC2 = new TestBean(5, "cccc");
        mapC1.put("ii22", new Object[]{1,2,3, beanC2});
        TestBean beanD3 = new TestBean(6, "dddd");
        List<Object> listD3 = new ArrayList<Object>(Arrays.asList(new Object[]{1,2,3, beanD3}));
        beanC2.setAttrD(listD3);
        beanC1.setAttrE(beanC2);
        beanC1.setAttrF(new char[]{'k','q','p'});
        mapC1.put("jj", beanC1);
        bean1.setAttrC(mapC1);
        map.put("d", bean1);
        map.put("z", new Object[]{ bean1 , beanC1} );
        
        Object obj = map;
        Object jsonObj = null;
        try {
            jsonObj = bareJsonBuilder.buildJsonStructure(obj, -1);
            // jsonObj = bareJsonBuilder.toJsonStructure(bean1, 5);
            // jsonObj = bareJsonBuilder.toJsonStructure(listD3, 1);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
//        if(jsonObj instanceof String) {
//            System.out.println("jsonObj is String.");            
//        } else {
//            System.out.println("jsonObj is not a String."); 
//        }
        System.out.println("jsonObj = " + jsonObj);

        // For tracing
        String jsonStr = null;
        try {
            jsonStr = bareJsonBuilder.build(jsonObj, 4);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("[3] jsonStr = " + jsonStr);


    }

}
