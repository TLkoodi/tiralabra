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
public class KoodinKaantajaTest {
    
    public KoodinKaantajaTest() {
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
     * Test of kaanna method, of class KoodinKaantaja.
     */
    @Test
    public void testKaanna() {
        System.out.println("kaanna");
        KoodinKaantaja instance = new KoodinKaantaja();
        String kaannos = instance.kaanna("lol");
        assertEquals("ete", kaannos);
        
    }
    
}
