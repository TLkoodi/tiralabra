/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja;

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
public class FrekvenssiolioTest {
    
    public FrekvenssiolioTest() {
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
     * Test of getKoodi method, of class Frekvenssiolio.
     */
    @Test
    public void testGetKoodi() {
        System.out.println("getKoodi");
        Frekvenssiolio instance = null;
        String expResult = "";
        char result = instance.getKoodi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kasvata method, of class Frekvenssiolio.
     */
    @Test
    public void testKasvata() {
        System.out.println("kasvata");
        Frekvenssiolio instance = null;
        instance.kasvata();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaara method, of class Frekvenssiolio.
     */
    @Test
    public void testGetMaara() {
        System.out.println("getMaara");
        Frekvenssiolio instance = null;
        int expResult = 0;
        int result = instance.getMaara();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Frekvenssiolio.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Frekvenssiolio o = null;
        Frekvenssiolio instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
