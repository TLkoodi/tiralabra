/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja;

import java.util.PriorityQueue;
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
public class FrekvenssitiedotTest {
    
    public FrekvenssitiedotTest() {
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
     * Test of haeEnglanti method, of class Frekvenssitiedot.
     */
    @Test
    public void testHaeEnglanti() {
        System.out.println("haeEnglanti");
        Frekvenssitiedot instance = new Frekvenssitiedot();
        PriorityQueue expResult = null;
        PriorityQueue result = instance.haeEnglanti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
