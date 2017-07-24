package org.minijson.tool.profiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.minijson.builder.BareJsonBuilder;
import org.minijson.builder.JsonBuilderException;
import org.minijson.builder.impl.AbstractBareJsonBuilder;
import org.minijson.builder.policy.base.DefaultBuilderPolicy;
import org.minijson.mini.MiniJsonParser;


public class JsonCompatibleRunner
{
    private static final Logger log = Logger.getLogger(MiniJsonParser.class.getName());

    private BareJsonBuilder bareJsonBuilder = null;
    public JsonCompatibleRunner()
    {
        init();
    }

    private void init()
    {
        bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.BEANDRILLDOWN) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.MAPANDLISTS) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.ESCAPESLASH) {};
        // bareJsonBuilder = new AbstractBareJsonBuilder(DefaultBuilderPolicy.NOESCAPESLASH) {};
//        ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.BEANDRILLDOWN);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.MAPANDLISTS);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.ESCAPESLASH);
//        // ((AbstractBareJsonBuilder) bareJsonBuilder).setBuilderPolicy(DefaultBuilderPolicy.NOESCAPESLASH);
    }
    
    public void runBuild()
    {
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        List<Object> list1 = new ArrayList<Object>();
        list1.add("x");
        list1.add("y\ny\ty\ry\\y ___ \\/ / ___ </ ___ y/y\"\u0033\u0035y\u001ay");
        list1.add("z");
        list1.add(null);
        map.put("a", list1);
        SampleJsonCompatibleObject jb1 = new SampleJsonCompatibleObject();
        map.put("a2", jb1);
        SampleJsonCompatibleArray jb2 = new SampleJsonCompatibleArray();
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

        SampleBean bean1 = new SampleBean(3, "aaaa");
        bean1.setAttrF(new char[]{'h','i'});
        Map<String,Object> mapC1 = new LinkedHashMap<String,Object>();
        mapC1.put("ii", 33);
        SampleBean beanC1 = new SampleBean(4, "bbbb");
        SampleBean beanC2 = new SampleBean(5, "cccc");
        mapC1.put("ii22", new Object[]{1,2,3, beanC2});
        SampleBean beanD3 = new SampleBean(6, "dddd");
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
        System.out.println("jsonObj = " + jsonObj);

//        // For tracing
//        String jsonStr = bareJsonBuilder.build(jsonObj, 4);
//        //  System.out.println("jsonStr = " + jsonStr);
//        int jsonLen = jsonStr.length();
//        System.out.println("jsonLen = " + jsonLen);


    }
    
    public static void main(String[] args)
    {
        System.out.println("Running...");
        
        JsonCompatibleRunner runner = new JsonCompatibleRunner();
        
        int counter = 0;
        while(counter < 200) {
            System.out.println(">>>> counter = " + counter);
            runner.runBuild();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++counter;
        }
        
        System.out.println("Done.");
    }
    
}
