/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja;

import koodinpurkaja.Tietorakenteet.Frekvenssiolio;
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
        String expResult = "";
        Frekvenssiolio instance = new Frekvenssiolio('T');
        char result = instance.getKoodi();
        assertEquals('T', result);
    }

    /**
     * Test of kasvata method, of class Frekvenssiolio.
     */
    @Test
    public void testKasvata() {
        System.out.println("kasvata");
        Frekvenssiolio instance = new Frekvenssiolio('T');
        instance.kasvata();
        instance.kasvata();
        assertEquals(2, instance.getMaara());
    }

    /**
     * Test of getMaara method, of class Frekvenssiolio.
     */
    @Test
    public void testGetMaara() {
        System.out.println("getMaara");
        Frekvenssiolio instance = new Frekvenssiolio('T');
        int expResult = 0;
        int result = instance.getMaara();
        assertEquals(0, result);
    }

    /**
     * Test of compareTo method, of class Frekvenssiolio.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Frekvenssiolio o = new Frekvenssiolio('O');
        Frekvenssiolio instance = new Frekvenssiolio('T');
        o.kasvata();
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
