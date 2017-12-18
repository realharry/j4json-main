package j4json.tool.profiler;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import j4json.builder.IndentedJsonBuilder;
import j4json.builder.JsonBuilderException;
import j4json.mini.MiniJsonBuilder;
import j4json.mini.MiniJsonParser;
import j4json.parser.JsonParserException;


public class MiniJsonParserRunner
{
    private static final Logger log = Logger.getLogger(MiniJsonParser.class.getName());

    private MiniJsonParser jsonParser = null;
    public MiniJsonParserRunner()
    {
        init();
    }

    private void init()
    {
        jsonParser = new MiniJsonParser();
        ((MiniJsonParser) jsonParser).enableLookAheadParsing();
        // ((MiniJsonParser) jsonParser).disableLookAheadParsing();
        // ((MiniJsonParser) jsonParser).enableTracing();
        ((MiniJsonParser) jsonParser).disableTracing();
    }
    
    public void runParse()
    {
        // Recreate MiniJsonParser for every run.
        // For profiling purposes. (when done through a loop, we need to re-initialize it at every run).
        // init();
        
        String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\mirrorapi.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json0.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json1.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json2.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\random-json3.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\fastjson-bug.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\sample.json";
        
        Object node = null;
        try {
            Reader reader = new FileReader(filePath);
            
            node = jsonParser.parse(reader);
            // System.out.println("node = " + node);
            String str = node.toString();
            // System.out.println("str = " + str);
            int len = str.length();
            System.out.println("str.lenth = " + len);
            
        } catch (FileNotFoundException e) {
            log.log(Level.WARNING, "Failed to find the JSON file: filePath = " + filePath, e);
        } catch (IOException e) {
            log.log(Level.WARNING, "Failed to parse the JSON file: filePath = " + filePath, e);
        } catch (JsonParserException e) {
            log.log(Level.WARNING, "Failed to parse the JSON file: filePath = " + filePath + "; context = " + e.getContext(), e);
        }

        
        // ..
        String outputPath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\j4json\\extra\\sample-output.json";
        
        // format the jsonStr
        IndentedJsonBuilder jsonBuilder = new MiniJsonBuilder();

//        Writer writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(outputPath));
//            // jsonBuilder.build(writer, node);
//            // jsonBuilder.build(writer, node, 4);
//            jsonBuilder.build(writer, node, -1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String jsonStr = null;
        try {
            jsonStr = jsonBuilder.build(node);
            // String jsonStr = jsonBuilder.build(node, 4);
            // String jsonStr = jsonBuilder.build(node, -1);
            // System.out.println("jsonStr = " + jsonStr);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        if(jsonStr != null) {
            int jsonLen = jsonStr.length();
            System.out.println("jsonStr.length = " + jsonLen);
        } else {
            System.out.println("Failed build JSON string.");
        }

    }
    
    public static void main(String[] args)
    {
        System.out.println("Running...");
        
        MiniJsonParserRunner runner = new MiniJsonParserRunner();
        
        int counter = 0;
        while(counter < 200) {
            System.out.println(">>>> counter = " + counter);
            runner.runParse();
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
