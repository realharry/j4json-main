package org.minijson.builder.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.minijson.JsonCompatible;
import org.minijson.builder.JsonBuilderException;


public class TestJsonCompatibleObject implements JsonCompatible
{

    public TestJsonCompatibleObject()
    {
    }

//    @Override
//    public boolean isJsonStructureArray()
//    {
//        return false;
//    }

    @Override
    public Object toJsonStructure() throws JsonBuilderException
    {
        return toJsonStructure(1);
    }

    @Override
    public Object toJsonStructure(int depth) throws JsonBuilderException
    {
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(depth > 0) {
            map.put("k1", "v1");
            if(depth > 1) {
                Map<String,Object> map2 = new LinkedHashMap<String,Object>();
                map2.put("x1", "y1");
                map.put("k2", map2);
                if(depth > 2) {
                    Map<String,Object> map3 = new LinkedHashMap<String,Object>();
                    map3.put("m1", "n1");
                    map2.put("x2", map3);
                }
            }
        }        
        return map;
    }

    @Override
    public String toString()
    {
        return "TestJsonCompatibleObject []";
    }

}
