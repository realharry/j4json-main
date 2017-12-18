package j4json.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import j4json.JsonObject;
import j4json.base.MiniJsonObject;
import j4json.base.MiniJsonWrapper;
import j4json.builder.JsonBuilderException;

public class JsonObjectTest
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
        Map<String,Object> jsonObj = map;

        JsonObject jsonObject = new MiniJsonObject(jsonObj);
        
        String jsonStr = null;
        try {
            jsonStr = jsonObject.toJsonString();
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);

    }

    @Test
    public void testToObject()
    {
        // String jsonStr = "{\"a\":[3, 5, 7]}";
        String jsonStr = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";
        
        MiniJsonWrapper jsonObject = new MiniJsonObject(jsonStr);

        Object obj = null;
        try {
            obj = jsonObject.toJsonStructure();
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("obj = " + obj);
        
    }

}
