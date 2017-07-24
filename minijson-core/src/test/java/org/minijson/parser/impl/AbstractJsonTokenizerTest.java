package org.minijson.parser.impl;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.parser.JsonParserException;
import org.minijson.parser.core.JsonToken;

public class AbstractJsonTokenizerTest
{
    private AbstractJsonTokenizer jsonTokenizer;
    
    @Before
    public void setUp() throws Exception
    {
        // String jsonStr = "{\"a\":[3, 5, 7]}";
        String jsonStr = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";
        jsonTokenizer = new AbstractJsonTokenizer(jsonStr) {};
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testNext()
    {
        JsonToken token = null;
        try {
            while(jsonTokenizer.hasMore()) {
                token = jsonTokenizer.next();
                System.out.println("token = " + token);
            }
        } catch (JsonParserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPeek()
    {
        JsonToken token1 = null;
        JsonToken token2 = null;
        try {
            while(jsonTokenizer.hasMore()) {
                token1 = jsonTokenizer.peek();
                token2 = jsonTokenizer.next();
                System.out.println("token1 = " + token1);
                System.out.println("token2 = " + token2);
                assertEquals(token1, token2);
            }
        } catch (JsonParserException e) {
            e.printStackTrace();
        }
    }

}
