package j4json.builder.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestBean
{
    private int attrA = 0;
    private String attrB = null;
    private Map<String,Object> attrC = null;
    private List<Object> attrD = null;
    private TestBean attrE = null;
    private char[] attrF = null;

    
    public TestBean(int attrA, String attrB)
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
    public TestBean getAttrE()
    {
        return attrE;
    }
    public void setAttrE(TestBean attrE)
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
        return "TestBean [attrA=" + attrA + ", attrB=" + attrB + ", attrC="
                + attrC + ", attrD=" + attrD + ", attrE=" + attrE + ", attrF="
                + Arrays.toString(attrF) + "]";
    }
  

}
