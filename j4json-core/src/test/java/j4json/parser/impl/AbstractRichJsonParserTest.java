package j4json.parser.impl;

import static org.junit.Assert.fail;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import j4json.builder.IndentedJsonBuilder;
import j4json.builder.JsonBuilderException;
import j4json.mini.MiniJsonBuilder;
import j4json.parser.JsonParserException;
import j4json.parser.RichJsonParser;
import j4json.type.JsonNode;


public class AbstractRichJsonParserTest
{

    private RichJsonParser jsonParser;
    
    @Before
    public void setUp() throws Exception
    {
        jsonParser = new AbstractRichJsonParser() {};
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

    @Test
    public void testParseJsonString()
    {
        // String jsonStr = "{\"a\":[3, 5, 7]}";
        String jsonStr = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";

        try {
            JsonNode node = jsonParser.parseJson(jsonStr);
            System.out.println("node = " + node);

        } catch (JsonParserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseJsonReader()
    {
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\fastjson-bug.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json1.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json2.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json3.json";
        String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\sample.json";
        
        Object node = null;
        try {
            Reader reader = new FileReader(filePath);
            
            node = jsonParser.parseJson(reader);
            System.out.println("node = " + node);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonParserException e) {
            e.printStackTrace();
            
            String context = e.getContext();
            System.out.println("context = " + context);
            
        }
        
        
        // format the jsonStr
        IndentedJsonBuilder jsonBuilder = new MiniJsonBuilder();
        String jsonStr = null;
        try {
            jsonStr = jsonBuilder.build(node, 4);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);
        

    }

}
