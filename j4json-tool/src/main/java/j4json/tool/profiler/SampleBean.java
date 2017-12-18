package j4json.tool.profiler;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SampleBean
{
    private int attrA = 0;
    private String attrB = null;
    private Map<String,Object> attrC = null;
    private List<Object> attrD = null;
    private SampleBean attrE = null;
    private char[] attrF = null;

    
    public SampleBean(int attrA, String attrB)
    {
        super();
        this.attrA = attrA;
        this.attrB = attrB;
    }

    public int getAttrA()
    {
        return attrA;
    }
    public void setAttrA(int attrA)
    {
        this.attrA = attrA;
    }
    public String getAttrB()
    {
        return attrB;
    }
    public void setAttrB(String attrB)
    {
        this.attrB = attrB;
    }
    public Map<String, Object> getAttrC()
    {
        return attrC;
    }
    public void setAttrC(Map<String, Object> attrC)
    {
        this.attrC = attrC;
    }
    public List<Object> getAttrD()
    {
        return attrD;
    }
    public void setAttrD(List<Object> attrD)
    {
        this.attrD = attrD;
    }
    public SampleBean getAttrE()
    {
        return attrE;
    }
    public void setAttrE(SampleBean attrE)
    {
        this.attrE = attrE;
    }

    public char[] getAttrF()
    {
        return attrF;
    }
    public void setAttrF(char[] attrF)
    {
        this.attrF = attrF;
    }

    @Override
    public String toString()
    {
        return "SampleBean [attrA=" + attrA + ", attrB=" + attrB + ", attrC="
                + attrC + ", attrD=" + attrD + ", attrE=" + attrE + ", attrF="
                + Arrays.toString(attrF) + "]";
    }
  

}
