package j4json.tool.testset;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


// Defines how to generate the JSON test data set.
public final class JsonTestSetSpec implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Number of test JSON strings.
    private final int count;
    
    // Default data spec
    // private JsonTestDataSpec dataSpec;

    // dataSepcs -> "weight".
    // (Weight does not have to be normalized, but they should be generally non-zero.)
    private final Map<JsonTestDataSpec, Double> dataSpecs;

    // Array vs Object.  --> Just use dataSpecs.weight.
    // private double arrayRatio;
    
    // Default errorRate
    // private double errorRate;
    

    public JsonTestSetSpec(int count)
    {
        this(count, null);
    }
    public JsonTestSetSpec(int count, Map<JsonTestDataSpec, Double> dataSpecs)
    {
        super();
        this.count = count;
        if(dataSpecs == null) {
            this.dataSpecs = new LinkedHashMap<JsonTestDataSpec, Double>();   // Preserving order, for convenience.
        } else {
            this.dataSpecs = dataSpecs;
        }
    }

    public int getCount()
    {
        return count;
    }

    public int specSize()
    {
        return dataSpecs.size();
    }

    public boolean isSpecEmpty()
    {
        return dataSpecs.isEmpty();
    }

    public boolean containsSpec(JsonTestDataSpec key)
    {
        return dataSpecs.containsKey(key);
    }

    // Returns the weight of the given dataSpec.
    public double getWeight(JsonTestDataSpec key)
    {
        Double d = dataSpecs.get(key);
        if(d == null) {
            return 0.0;
        } else {
            return d;
        }
    }
    // Returns the sum of all weights.
    public double getTotalWeight()
    {
        Collection<Double> values = dataSpecs.values();
        double sum = 0.0;
        for(Double d : values) {
            if(d != null) {
                sum += d;
            }
        }
        return sum;
    }

    public Double addSpec(JsonTestDataSpec key)
    {
        // Default weight
        double weight = 1.0;
        return putSpec(key, weight);
    }
    public Double putSpec(JsonTestDataSpec key, Double value)
    {
        return dataSpecs.put(key, value);
    }

    public Double removeSpec(JsonTestDataSpec key)
    {
        return dataSpecs.remove(key);
    }

    public void putSpecs(Map<? extends JsonTestDataSpec, ? extends Double> m)
    {
        dataSpecs.putAll(m);
    }

    public void clearSpecs()
    {
        dataSpecs.clear();
    }

    public Set<JsonTestDataSpec> specSet()
    {
        return dataSpecs.keySet();
    }



    @Override
    public String toString()
    {
        return "JsonTestSetSpec [count=" + count + ", dataSpecs=" + dataSpecs
                + "]";
    }

    
}
