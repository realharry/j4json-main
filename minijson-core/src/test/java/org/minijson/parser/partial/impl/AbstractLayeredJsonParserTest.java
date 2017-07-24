package org.minijson.parser.partial.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.builder.JsonBuilderException;
import org.minijson.builder.impl.AbstractBareJsonBuilder;
import org.minijson.parser.JsonParserException;
import org.minijson.parser.partial.impl.AbstractLayeredJsonParser;

public class AbstractLayeredJsonParserTest
{
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
    }

    private AbstractLayeredJsonParser jsonParser = null;
    private AbstractBareJsonBuilder jsonBuilder = null;
    
    @Before
    public void setUp() throws Exception
    {
        jsonParser = new AbstractLayeredJsonParser() {};
        jsonBuilder = new AbstractBareJsonBuilder() {};
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testParseStringInt()
    {
        Object obj = null;
        String jsonStr = null;
        for(int d=0; d<8; d++) {
            System.out.println("depth = " + d);
            try {
                obj = jsonParser.parse(jsonString2, d);
                // System.out.println("obj = " + obj);
                // For printing...
                jsonStr = jsonBuilder.build(obj, 4);
                System.out.println("jsonStr = " + jsonStr);
            // } catch (JsonParserException | JsonBuilderException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    @Test
    public void testParseGeneratedJson()
    {
        String jsonStr1 = "[{\"j2_4\": [{\"m2_7\": \"n2_8\", \"m1_7\": \"n1_8\"}], \"j1_4\": \"k1_4\\tccc\"}]";
        String jsonStr2 = "{\"j2_4\": [{\"m2_7\": \"n2_8\", \"m1_7\": \"n1_8\"}], \"j1_4\": \"k1_4\\tccc\"}";
        String jsonStr3 = "[{\"m2_7\": \"n2_8\", \"m1_7\": \"n1_8\"}]";

        try {
            Object obj1 = jsonParser.parse(jsonStr1);
            String objStr1 = jsonBuilder.build(obj1, 4);
            System.out.println("objStr1 = " + objStr1);
            Object obj2 = jsonParser.parse(jsonStr2);
            String objStr2 = jsonBuilder.build(obj2, 4);
            System.out.println("objStr2 = " + objStr2);
            Object obj3 = jsonParser.parse(jsonStr3);
            String objStr3 = jsonBuilder.build(obj3, 4);
            System.out.println("objStr3 = " + objStr3);
        // } catch (JsonParserException | JsonBuilderException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
    }
    
}
