package org.minijson.tool.profiler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.minijson.JsonCompatible;
import org.minijson.builder.JsonBuilderException;


public class SampleJsonCompatibleArray implements JsonCompatible
{

    public SampleJsonCompatibleArray()
    {
    }

//    @Override
//    public boolean isJsonStructureArray()
//    {
//        return true;
//    }

    @Override
    public Object toJsonStructure() throws JsonBuilderException
    {
        return toJsonStructure(1);
    }

    @Override
    public Object toJsonStructure(int depth) throws JsonBuilderException
    {
        List<Object> list = new ArrayList<Object>();
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        if(depth > 0) {
            list.add(map);
            if(depth > 1) {
                map.put("k1", "v1");
                if(depth > 2) {
                    Map<String,Object> map2 = new LinkedHashMap<String,Object>();
                    map2.put("x1", "y1");
                    map.put("k2", map2);
                    if(depth > 3) {
                        Map<String,Object> map3 = new LinkedHashMap<String,Object>();
                        map3.put("m1", "n1");
                        map2.put("x2", map3);
                    }
                }
            }        
        }        
        return list;
    }

    @Override
    public String toString()
    {
        return "SampleJsonCompatibleArray []";
    }

}
