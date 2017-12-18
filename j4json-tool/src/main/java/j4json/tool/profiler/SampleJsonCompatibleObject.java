package j4json.tool.profiler;

import java.util.LinkedHashMap;
import java.util.Map;

import j4json.JsonCompatible;
import j4json.builder.JsonBuilderException;


public class SampleJsonCompatibleObject implements JsonCompatible
{

    public SampleJsonCompatibleObject()
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
        return "SampleJsonCompatibleObject []";
    }

}