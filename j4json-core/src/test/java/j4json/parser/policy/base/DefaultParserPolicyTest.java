package j4json.parser.policy.base;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import j4json.parser.policy.ParserPolicy;


public class DefaultParserPolicyTest
{

    @Test
    public void testDefaultParserPolicy()
    {
        
//        char[] c = null;
//        String x = new String(c);
//        System.out.println("x = " + x);

        ParserPolicy parserPolicy = DefaultParserPolicy.MINIJSON;
        boolean strict = parserPolicy.isStrirct();
        System.out.println("strict = " + strict);
        assertEquals(false, strict);
        boolean allowNonObjectOrNonArray = parserPolicy.allowNonObjectOrNonArray();
        System.out.println("allowNonObjectOrNonArray = " + allowNonObjectOrNonArray);
        assertEquals(true, allowNonObjectOrNonArray);
    }


}
