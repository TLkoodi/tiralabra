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
public class TiedostonlukijaTest {
    
    public TiedostonlukijaTest() {
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
     * Test of kokoTiedostoStringiksi method, of class Tiedostonlukija.
     */
    @Test
    public void testLueTiedosto() {
        System.out.println("kokoTiedostoStringiksi");
        Tiedostonlukija instance = new Tiedostonlukija();
        String expResult = "testaus 1";
        String result = instance.lueTiedosto("testi.txt");
        assertEquals(expResult, result);
    }
    
}
