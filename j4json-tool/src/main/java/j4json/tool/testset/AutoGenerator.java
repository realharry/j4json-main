package j4json.tool.testset;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import j4json.builder.IndentedJsonBuilder;
import j4json.builder.JsonBuilderException;
import j4json.mini.MiniJsonBuilder;


// Auto generates a set of JSON strings according to the given spec...
// ...
// This effort has been abandoned.
// This class is not completely implemented...
// ...
public class AutoGenerator implements Generator
{
    private static final Logger log = Logger.getLogger(AutoGenerator.class.getName());

    private static final Random sRandom = new Random(System.currentTimeMillis());
    
    public AutoGenerator()
    {
    }

    @Override
    public List<String> generateTestSet(JsonTestSetSpec jsonTestSetSpec)
    {
        if(jsonTestSetSpec == null || jsonTestSetSpec.isSpecEmpty()) {
            log.warning("jsonTestSetSpec is null/empty. Cannot proceed.");
            return null;
        }
        
        // re-process the data first
        
        int size = jsonTestSetSpec.specSize();
        List<JsonTestDataSpec> specs = new ArrayList<JsonTestDataSpec>();
        List<Double> weights = new ArrayList<Double>();
        List<Double> cumulWeights = new ArrayList<Double>();
        
        double cumulWeight = 0.0;
        double totalWeight = 0.0;
        for(JsonTestDataSpec s : jsonTestSetSpec.specSet()) {
            specs.add(s);
            double w = jsonTestSetSpec.getWeight(s);
            w += 0.01;     // In case all weights are zero (even when some of them are), we add some small non-zero values.
            weights.add(w);
            cumulWeight += w;
            cumulWeights.add(cumulWeight);
            totalWeight = cumulWeight;
        }

        
        for(int i=0; i< size; i++) {
        }

        // Json serializer.
        IndentedJsonBuilder jsonBuilder = new MiniJsonBuilder();
        
        List<String> jsonStrList = new ArrayList<String>();
        int count = jsonTestSetSpec.getCount();
        for(int c=0; c<count; c++) {
            
            double r = sRandom.nextDouble() * totalWeight;

            int p = -1;
            for(int i=0; i< size; i++) {
                double w = cumulWeights.get(i);
                if(r < w) {
                    p = i;
                    break;
                }
            }
            if(p == -1) {
                // ???
                p = size - 1;
            }
            
            JsonTestDataSpec dataSpec = specs.get(p);
            
            Object testObj = generateTestObject(dataSpec);
            String jsonStr = null;
            try {
                jsonStr = jsonBuilder.build(testObj);
            } catch (JsonBuilderException e) {
                log.log(Level.WARNING, "Failed to generate JSON string.", e);
            }
            
            if(jsonStr != null) {
                jsonStrList.add(jsonStr);
            }
        }
        
        return jsonStrList;
    }

    
    
    private Object generateTestObject(JsonTestDataSpec dataSpec)
    {
        boolean isArray = dataSpec.isArrayType();
        
        int minSize = dataSpec.getMinSize();
        int maxSize = dataSpec.getMaxSize();
        int minDepth = dataSpec.getMinDepth();
        int maxDepth = dataSpec.getMaxDepth();
        double errorRate = dataSpec.getErrorRate();
        boolean allowUnicode = dataSpec.isAllowUnicode();

        
        Object topNode = null;
        if(isArray) {
            topNode = new ArrayList<Object>();
            
            // tbd..
            
        } else {
            topNode = new LinkedHashMap<String,Object>();
            
            
            // tbd ...
            
            
        }
        
        
        return topNode;
    }
    
    
    
}
