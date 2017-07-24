package org.minijson.tool.testset;

import java.io.Serializable;


// Sort of a "template" or "spec" to generate a JSON string.
public final class JsonTestDataSpec implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Object or array
    // private String type;   // "object" vs "array"?
    private final boolean arrayType;
    // Array vs Object.
    // private double arrayRatio;

    // size in terms of the number of chars.
    // -1 means no limit
    private int minSize;
    private int maxSize;
    
    // In terms of the nested {}/[]
    // -1 means no limit.
    private int minDepth;
    private int maxDepth;
    
    // Number of deleted/incorrectly added chars (from a valid JSON)
    // private int errorCount;
    // 0.0 <= rate <= 1.0.
    private double errorRate;

    // ???
    private boolean allowUnicode;

    
    // Ctor's
    public JsonTestDataSpec()
    {
        this(false);
    }
    public JsonTestDataSpec(boolean arrayType)
    {
        this(arrayType, -1, -1);
    }
    public JsonTestDataSpec(boolean arrayType, int minSize, int maxSize)
    {
        this(arrayType, minSize, maxSize, -1, -1, 0.0, false);
    }
    public JsonTestDataSpec(boolean arrayType, int minSize, int maxSize,
            int minDepth, int maxDepth, double errorRate, boolean allowUnicode)
    {
        super();
        this.arrayType = arrayType;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.errorRate = errorRate;
        this.allowUnicode = allowUnicode;
    }

    public boolean isArrayType()
    {
        return arrayType;
    }

    public int getMinSize()
    {
        return minSize;
    }
    public void setMinSize(int minSize)
    {
        this.minSize = minSize;
    }

    public int getMaxSize()
    {
        return maxSize;
    }
    public void setMaxSize(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public int getMinDepth()
    {
        return minDepth;
    }
    public void setMinDepth(int minDepth)
    {
        this.minDepth = minDepth;
    }

    public int getMaxDepth()
    {
        return maxDepth;
    }
    public void setMaxDepth(int maxDepth)
    {
        this.maxDepth = maxDepth;
    }

    public double getErrorRate()
    {
        return errorRate;
    }
    public void setErrorRate(double errorRate)
    {
        this.errorRate = errorRate;
    }

    public boolean isAllowUnicode()
    {
        return allowUnicode;
    }
    public void setAllowUnicode(boolean allowUnicode)
    {
        this.allowUnicode = allowUnicode;
    }

    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (allowUnicode ? 1231 : 1237);
        result = prime * result + (arrayType ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(errorRate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + maxDepth;
        result = prime * result + maxSize;
        result = prime * result + minDepth;
        result = prime * result + minSize;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JsonTestDataSpec other = (JsonTestDataSpec) obj;
        if (allowUnicode != other.allowUnicode)
            return false;
        if (arrayType != other.arrayType)
            return false;
        if (Double.doubleToLongBits(errorRate) != Double
                .doubleToLongBits(other.errorRate))
            return false;
        if (maxDepth != other.maxDepth)
            return false;
        if (maxSize != other.maxSize)
            return false;
        if (minDepth != other.minDepth)
            return false;
        if (minSize != other.minSize)
            return false;
        return true;
    }

    
    @Override
    public String toString()
    {
        return "JsonTestDataSpec [arrayType=" + arrayType + ", minSize="
                + minSize + ", maxSize=" + maxSize + ", minDepth=" + minDepth
                + ", maxDepth=" + maxDepth + ", errorRate=" + errorRate
                + ", allowUnicode=" + allowUnicode + "]";
    }


}
