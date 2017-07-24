package org.minijson.parser.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CharQueueTest
{

    private CharQueue charQueue;
    
    @Before
    public void setUp() throws Exception
    {
        charQueue = new CharQueue(10);
    }

    @After
    public void tearDown() throws Exception
    {
    }


    @Test
    public void testOffer()
    {
        int size1 = charQueue.size();
        System.out.println("size1 = " + size1);

        charQueue.add('a');
        System.out.println("charQueue = " + charQueue);

        int size2 = charQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 1, size2);
    }

    @Test
    public void testPoll()
    {
        int size1 = charQueue.size();
        System.out.println("size1 = " + size1);

        charQueue.add('a');
        charQueue.add('b');
        charQueue.add('c');
        System.out.println("charQueue = " + charQueue);

        char c = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        System.out.println("c = " + c);
        assertEquals('a', c);

        int size2 = charQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 2, size2);
    }

    @Test
    public void testPeek()
    {
        int size1 = charQueue.size();
        System.out.println("size1 = " + size1);

        charQueue.add('a');
        charQueue.add('b');
        charQueue.add('c');
        System.out.println("charQueue = " + charQueue);

        char c = charQueue.peek();
        System.out.println("charQueue = " + charQueue);
        System.out.println("c = " + c);
        assertEquals('a', c);

        int size2 = charQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 3, size2);
    }

    @Test
    public void testAddAll()
    {
        int size1 = charQueue.size();
        System.out.println("size1 = " + size1);

        char[] buff1 = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        charQueue.addAll(buff1);
        System.out.println("charQueue = " + charQueue);

        int size2 = charQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 8, size2);

        char c1 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        System.out.println("c1 = " + c1);
        assertEquals('a', c1);
        char c2 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        System.out.println("c2 = " + c2);
        assertEquals('b', c2);
        char c3 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        System.out.println("c3 = " + c3);
        assertEquals('c', c3);
        char[] cc = charQueue.poll(3);
        System.out.println("charQueue = " + charQueue);
        System.out.println("cc = " + Arrays.toString(cc));
        assertEquals('d', cc[0]);
        assertEquals('e', cc[1]);
        assertEquals('f', cc[2]);
        char c4 = charQueue.peek();
        System.out.println("charQueue = " + charQueue);
        System.out.println("c4 = " + c4);
        assertEquals('g', c4);

        int size3 = charQueue.size();
        System.out.println("size3 = " + size3);
        assertEquals(size2 - 6, size3);

        char[] buff2 = new char[] {'i', 'j', 'k', 'l'};
        charQueue.addAll(buff2);
        System.out.println("charQueue = " + charQueue);

        int size4 = charQueue.size();
        System.out.println("size4 = " + size4);
        assertEquals(size3 + 4, size4);

        charQueue.add('m');
        charQueue.add('n');
        charQueue.add('o');
        System.out.println("charQueue = " + charQueue);

        boolean suc = charQueue.add('p');
        System.out.println("charQueue = " + charQueue);
        assertEquals(false, suc);
        
        char c7 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        assertEquals('g', c7);
        char c8 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        assertEquals('h', c8);
        char c9 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        assertEquals('i', c9);
        char c10 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        assertEquals('j', c10);
        char c11 = charQueue.peek();
        System.out.println("charQueue = " + charQueue);
        assertEquals('k', c11);
        char c12 = charQueue.poll();
        System.out.println("charQueue = " + charQueue);
        assertEquals('k', c12);

        charQueue.add('p');
        System.out.println("charQueue = " + charQueue);

        charQueue.clear();
        System.out.println("charQueue = " + charQueue);
        int size9 = charQueue.size();
        System.out.println("size9 = " + size9);
        assertEquals(0, size9);


    }

}
