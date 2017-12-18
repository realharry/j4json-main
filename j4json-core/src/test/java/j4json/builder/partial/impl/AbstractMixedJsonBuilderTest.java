package j4json.builder.partial.impl;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import j4json.builder.JsonBuilderException;
import j4json.parser.JsonParserException;
import j4json.parser.impl.AbstractBareJsonParser;

public class AbstractMixedJsonBuilderTest
{
    private static final Map<String,Object> jsonObj;

    private static final String jsonString1;
    private static final String jsonString2;
    static {
        
        jsonString1 = "{" +
                "  \"id\": \"3h\"," +
                "  \"attachments\": [" +
                "      {" +
                "          \"contentType\": \"image/jpeg\"," +
                "          \"id\": \"aid\"" +
                "      }" +
                "  ]," +
                "  \"recipients\": [" +
                "      {" +
                "          \"kind\": \"glass#contact\"," +
                "          \"source\": \"api:sid\"," +
                "          \"id\": \"cid\"," +
                "          \"displayName\": \"name\"," +
                "          \"imageUrls\": [" +
                "              \"name\"" +
                "          ]" +
                "      }" +
                "  ]" +
                "}";
        
        jsonString2 = "{" +
                "  \"k1_1\": \"v1_2\"," +
                "  \"k2_1\": [" +
                "      {" +
                "          \"h1_3\": \"i1_4\"," +
                "          \"h2_3\": \"i2_4\nbbb\"" +
                "      }" +
                "  ]," +
                "  \"k3_1\": [" +
                "      {" +
                "          \"j1_4\": \"k1_4\tccc\"," +
                "          \"j2_4\": [" +
                "              {" +
                "                  \"m1_7\": \"n1_8\"," +
                "                  \"m2_7\": \"n2_8\"" +
                "              }" +
                "          ]" +
                "      }" +
                "  ]" +
                "}";
        
        
        jsonObj = new HashMap<String,Object>();
        jsonObj.put("key 1", jsonString1);
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("level 2", jsonString2);
        jsonObj.put("key 2", map1);
        
    }

    // private AbstractBareJsonParser jsonParser = null;
    private AbstractMixedJsonBuilder jsonBuilder = null;
    
    @Before
    public void setUp() throws Exception
    {
        // jsonParser = new AbstractBareJsonParser() {};
        jsonBuilder = new AbstractMixedJsonBuilder() {};
    }


    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testBuildMixedObjectInt()
    {
        String jsonStr = null;
        int min = 0;
        for(int max=0; max<4; max++) {
            System.out.println("min depth = " + min + "; max depth = " + max);
            try {
                jsonStr = jsonBuilder.buildMixed(jsonObj, min, max, 4);
                System.out.println("jsonStr = " + jsonStr);
            } catch (JsonBuilderException e) {
                e.printStackTrace();
            }
        }
    }

    // @Test
    public void testBuildMixedWriterObjectInt()
    {
        // fail("Not yet implemented");
    }

}
