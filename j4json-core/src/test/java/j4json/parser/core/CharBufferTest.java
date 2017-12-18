package j4json.parser.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CharBufferTest
{

    private CharBuffer charBuffer;
    
    @Before
    public void setUp() throws Exception
    {
        charBuffer = new CharBuffer(10);
    }

    @After
    public void tearDown() throws Exception
    {
    }


    @Test
    public void testPush()
    {
        int size1 = charBuffer.size();
        System.out.println("size1 = " + size1);

        charBuffer.push('a');
        System.out.println("charBuffer = " + charBuffer);

        int size2 = charBuffer.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 1, size2);
    }

    @Test
    public void testTail()
    {
        int size1 = charBuffer.size();
        System.out.println("size1 = " + size1);

        charBuffer.push('a');
        charBuffer.push('b');
        charBuffer.push('c');
        System.out.println("charBuffer = " + charBuffer);

        char c = charBuffer.tail();
        System.out.println("charBuffer = " + charBuffer);
        System.out.println("c = " + c);
        assertEquals('c', c);

        int size2 = charBuffer.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 3, size2);
    }


    @Test
    public void testTail2()
    {
        int size1 = charBuffer.size();
        System.out.println("size1 = " + size1);

        char[] buff1 = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        charBuffer.push(buff1);
        System.out.println("charBuffer = " + charBuffer);

        int size2 = charBuffer.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 8, size2);

        char c1 = charBuffer.tail();
        System.out.println("charBuffer = " + charBuffer);
        System.out.println("c1 = " + c1);
        assertEquals('h', c1);
        char[] cc = charBuffer.tail(3);
        System.out.println("charBuffer = " + charBuffer);
        System.out.println("cc = " + Arrays.toString(cc));
        assertEquals('f', cc[0]);
        assertEquals('g', cc[1]);
        assertEquals('h', cc[2]);
        char c4 = charBuffer.tail();
        System.out.println("charBuffer = " + charBuffer);
        System.out.println("c4 = " + c4);
        assertEquals('h', c4);

        int size3 = charBuffer.size();
        System.out.println("size3 = " + size3);
        assertEquals(size2, size3);

        char[] buff2 = new char[] {'i', 'j', 'k', 'l'};
        charBuffer.push(buff2);
        System.out.println("charBuffer = " + charBuffer);

        int size4 = charBuffer.size();
        System.out.println("size4 = " + size4);
        assertEquals(9, size4);

        charBuffer.push('m');
        charBuffer.push('n');
        charBuffer.push('o');
        System.out.println("charBuffer = " + charBuffer);

        boolean suc = charBuffer.push('p');
        System.out.println("charBuffer = " + charBuffer);
        assertEquals(true, suc);
        
        char c7 = charBuffer.tail();
        System.out.println("charBuffer = " + charBuffer);
        assertEquals('p', c7);

        charBuffer.push('q');
        System.out.println("charBuffer = " + charBuffer);

        char[] dd = charBuffer.tail(20);
        System.out.println("charBuffer = " + charBuffer);
        System.out.println("dd = " + Arrays.toString(dd));
        assertEquals('i', dd[0]);
        assertEquals('j', dd[1]);
        assertEquals('k', dd[2]);
        // etc.

        charBuffer.clear();
        System.out.println("charBuffer = " + charBuffer);
        int size9 = charBuffer.size();
        System.out.println("size9 = " + size9);
        assertEquals(0, size9);


    }

    @Test
    public void testTailAsString()
    {
        char[] c = new char[]{'w','x','y','z','I',' ','a','m',' ','m','e','.'};
        charBuffer.push(c);
        System.out.println("charBuffer = " + charBuffer);
        String str = charBuffer.tailAsString(8);
        System.out.println("str = " + str);
        assertEquals("yzI am m", str);
        
    }

    @Test
    public void testBufferAsString()
    {
        char[] c = new char[]{'w','x','y','z','I',' ','a','m',' ','m','e','.'};
        charBuffer.push(c);
        System.out.println("charBuffer = " + charBuffer);
        
        int cap = charBuffer.maxCapacity();
        System.out.println("cap = " + cap);
        assertEquals(9, cap);
        
        String str = charBuffer.bufferAsString();
        System.out.println("str = " + str);
        assertEquals("xyzI am m", str);
        
    }
    
}
