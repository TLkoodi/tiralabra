/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja.Tietorakenteet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony
 */
public class SettiTest {

    public SettiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Setti.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Setti instance = new Setti();
        instance.add('4');
        boolean result = instance.contains('4');
        assertEquals(true, result);
    }

    /**
     * Test of remove method, of class Setti.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Setti instance = new Setti();
        instance.add('4');
        instance.remove('4');
        boolean result = instance.contains('4');
        assertEquals(false, result);
    }

    /**
     * Test of contains method, of class Setti.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Comparable haettava = null;
        Setti instance = new Setti();
         instance.add('4');
          instance.add('7');
           instance.add('X');
        boolean result = instance.contains('X');
        assertEquals(true, result);
    }
    
    @Test
    public void testContainsFalse() {
        System.out.println("contains");
        Comparable haettava = null;
        Setti instance = new Setti();
         instance.add('4');
          instance.add('7');
           instance.add('X');
        boolean result = instance.contains('Q');
        assertEquals(false, result);
    }

    /**
     * Test of poll method, of class Setti.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        Setti instance = new Setti();
        instance.add('4');
        Comparable expResult = '4';
        Comparable result = instance.poll();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPollNull() {
        System.out.println("poll");
        Setti instance = new Setti();
        instance.add('3');
        instance.poll();
        Comparable expResult = null;
        Comparable result = instance.poll();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPollUseampi() {
        System.out.println("poll");
        Setti instance = new Setti();
        instance.add('4');
        instance.add('1');
        instance.add('7');
        instance.add('9');
        instance.add('3');
        instance.poll();
        instance.poll();
        instance.poll();
        instance.poll();
        Comparable expResult = '4';
        Comparable result = instance.poll();
        assertEquals(expResult, result);
    }

}
