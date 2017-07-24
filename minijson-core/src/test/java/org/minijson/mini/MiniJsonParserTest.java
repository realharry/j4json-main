package org.minijson.mini;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.mini.MiniJsonParser;
import org.minijson.parser.JsonParser;
import org.minijson.parser.JsonParserException;


public class MiniJsonParserTest
{

    private JsonParser jsonParser;
    
    @Before
    public void setUp() throws Exception
    {
        jsonParser = new MiniJsonParser();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    // @Test
    public void testParseString()
    {
        fail("Not yet implemented");
    }

    // @Test
    public void testParseReader()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testParseJsonString()
    {
        // String jsonStr = "{\"a\":[3, 5, 7]}";
        String jsonStr = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";

        try {
            Object node = jsonParser.parse(jsonStr);
            System.out.println("node = " + node);

        } catch (JsonParserException e) {
            e.printStackTrace();
        }
    }

    // @Test
    public void testParseJsonReader()
    {
        fail("Not yet implemented");
    }

}
