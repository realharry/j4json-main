package org.minijson.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TailArrayQueueTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testOfferE()
    {
        TailArrayQueue<String> queue = new TailArrayQueue<String>(4);
        System.out.println("queue = " + queue);
        
        queue.offer("a");
        System.out.println("queue = " + queue);
        String e1 = queue.poll();
        System.out.println("e1 = " + e1);
        System.out.println("queue = " + queue);
        assertEquals("a", e1);
        
        queue.offer("b");
        System.out.println("queue = " + queue);
        String e2 = queue.peek();
        System.out.println("e2 = " + e2);
        System.out.println("queue = " + queue);
        assertEquals("b", e2);
        
        queue.offer("c");
        System.out.println("queue = " + queue);
        String e3 = queue.poll();
        System.out.println("e3 = " + e3);
        System.out.println("queue = " + queue);
        assertEquals("b", e3);

        queue.offer("d");
        System.out.println("queue = " + queue);
        
        queue.offer("e");
        System.out.println("queue = " + queue);
        
        queue.offer("f");
        System.out.println("queue = " + queue);
        String e4 = queue.poll();
        System.out.println("e4 = " + e4);
        System.out.println("queue = " + queue);
        assertEquals("c", e4);

        queue.offer("g");
        System.out.println("queue = " + queue);
        
        queue.offer("h");
        System.out.println("queue = " + queue);
        String e5 = queue.poll();
        System.out.println("e5 = " + e5);
        System.out.println("queue = " + queue);
        assertEquals("e", e5);

        queue.offer("i");
        System.out.println("queue = " + queue);
        
        queue.offer("j");
        System.out.println("queue = " + queue);

    
    
    }

}
