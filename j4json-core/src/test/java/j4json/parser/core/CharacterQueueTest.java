package j4json.parser.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharacterQueueTest
{

    private CharacterQueue characterQueue;
    
    @Before
    public void setUp() throws Exception
    {
        characterQueue = new CharacterQueue();
    }

    @After
    public void tearDown() throws Exception
    {
    }


    @Test
    public void testOffer()
    {
        int size1 = characterQueue.size();
        System.out.println("size1 = " + size1);

        characterQueue.offer('a');
        System.out.println("characterQueue = " + characterQueue);

        int size2 = characterQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 1, size2);
    }

    @Test
    public void testPoll()
    {
        int size1 = characterQueue.size();
        System.out.println("size1 = " + size1);

        characterQueue.offer('a');
        characterQueue.offer('b');
        characterQueue.offer('c');
        System.out.println("characterQueue = " + characterQueue);

        char c = characterQueue.poll();
        System.out.println("characterQueue = " + characterQueue);
        System.out.println("c = " + c);
        assertEquals('a', c);

        int size2 = characterQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 2, size2);
    }

    @Test
    public void testPeek()
    {
        int size1 = characterQueue.size();
        System.out.println("size1 = " + size1);

        characterQueue.offer('a');
        characterQueue.offer('b');
        characterQueue.offer('c');
        System.out.println("characterQueue = " + characterQueue);

        char c = characterQueue.peek();
        System.out.println("characterQueue = " + characterQueue);
        System.out.println("c = " + c);
        assertEquals('a', c);

        int size2 = characterQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 3, size2);
    }

    @Test
    public void testAddAll()
    {
        int size1 = characterQueue.size();
        System.out.println("size1 = " + size1);

        List<Character> buff = new ArrayList<Character>(Arrays.asList(new Character[]{'a', 'b', 'c'}));
        characterQueue.addAll(buff);
        System.out.println("characterQueue = " + characterQueue);

        int size2 = characterQueue.size();
        System.out.println("size2 = " + size2);
        assertEquals(size1 + 3, size2);
    }

}
