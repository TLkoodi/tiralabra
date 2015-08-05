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
public class SalakoodiTest {
    
    public SalakoodiTest() {
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
     * Test of lisaaTeksti method, of class Salakoodi.
     */
    @Test
    public void testLisaaTeksti() {
        System.out.println("lisaaTeksti");
        String lisattava = "justjust";
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti(lisattava);
        String teksti = instance.getTeksti();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("justjust", teksti);
    }

    /**
     * Test of lueTeksti method, of class Salakoodi.
     */
    @Test
    public void testLueTeksti() {
        System.out.println("lueTeksti");
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        String lisataan = "juupajuu";
        instance.setTeksti(lisataan);
        String result = instance.getTeksti();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("juupajuu", result);
    }


    
}
