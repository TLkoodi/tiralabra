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
public class PriorisoituJonoTest {
    
    public PriorisoituJonoTest() {
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
     * Test of add method, of class PriorisoituJono.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        PriorisoituJono instance = new PriorisoituJono();
        instance.add(1);
        instance.add(2);
        instance.add(7);
        instance.add(3);
        
        assertEquals(7, instance.poll());
    }
    
    @Test
    public void testPoll() {
        System.out.println("poll");
        PriorisoituJono instance = new PriorisoituJono();
        instance.add(1);
        
        assertEquals(1, instance.poll());
    }
    
    @Test
    public void testPeek() {
        System.out.println("peek");
        PriorisoituJono instance = new PriorisoituJono();
        instance.add(1);
        assertEquals(1, instance.peek());
    }
    
    @Test
    public void testPeekAlaKuitenkaanPoistaHaettuaArvoa() {
        System.out.println("peek");
        PriorisoituJono instance = new PriorisoituJono();
        instance.add(1);
        instance.peek();
        assertEquals(1, instance.poll());
    }
    
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        PriorisoituJono instance = new PriorisoituJono();
        assertEquals(true, instance.isEmpty());
    }
    
    @Test
    public void testIsEmptyJosTyhjennetty() {
        System.out.println("isEmpty");
        PriorisoituJono instance = new PriorisoituJono();
        instance.add(1);
        instance.add(24242);
        instance.poll();
        instance.poll();
        assertEquals(true, instance.isEmpty());
    }
    
}
