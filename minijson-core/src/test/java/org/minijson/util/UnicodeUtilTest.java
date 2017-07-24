package org.minijson.util;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.util.UnicodeUtil;

public class UnicodeUtilTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    // @Test
    public void testGetUnicodeCharFromHexSequence()
    {
        char[] c1 = new char[]{'0','0','3','5'};
        char u1 = UnicodeUtil.getUnicodeCharFromHexSequence(c1);
        System.out.println("u1 = " + u1);
        assertEquals('5', u1);

        char[] c2 = new char[]{'0','0','5','d'};
        char u2 = UnicodeUtil.getUnicodeCharFromHexSequence(c2);
        System.out.println("u2 = " + u2);
        assertEquals(']', u2);
        
    }

    @Test
    public void testGetUnicodeCodeFromChar()
    {
        char[] c1 = UnicodeUtil.getUnicodeHexCodeFromChar('0');
        System.out.println("c1 = " + Arrays.toString(c1));
        // assertEquals("\\u0030".toCharArray(), c1);

        char[] c2 = UnicodeUtil.getUnicodeHexCodeFromChar('a');
        System.out.println("c2 = " + Arrays.toString(c2));
        //assertEquals("".toCharArray(), c2);

        
    }

}
