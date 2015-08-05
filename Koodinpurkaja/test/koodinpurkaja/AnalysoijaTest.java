/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja;

import java.util.HashMap;
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
public class AnalysoijaTest {
    
    public AnalysoijaTest() {
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
     * Test of analysoiFrekvenssi method, of class Analysoija.
     */
    @Test
    public void testAnalysoiFrekvenssi() {
        System.out.println("analysoiFrekvenssi");
        String teksti = "sdsdldkPPPPPPPPPPPPPPPPPPPPPPsldklk";
        Analysoija instance = new Analysoija();
        PriorityQueue<Frekvenssiolio> result = instance.analysoiFrekvenssi(teksti);
        Character kirjain = 'P';
        assertEquals(kirjain, result.poll().getKoodi());
    }

    /**
     * Test of laskeKirjaimet method, of class Analysoija.
     */
    
    @Test
    public void testLaskeKirjaimetTuleekoOikeaMaaraOlioita() {
        System.out.println("laskeKirjaimet");
        String teksti = "kissa";
        Analysoija instance = new Analysoija();
        HashMap<Character, Frekvenssiolio> result = instance.laskeKirjaimet(teksti);
        int i = 4;
        assertEquals(4, result.size());
    }

    /**
     * Test of laskeKirjaimet method, of class Analysoija.
     */
    @Test
    public void testLaskeKirjaimet() {
        System.out.println("laskeKirjaimet");
        String teksti = "";
        Analysoija instance = new Analysoija();
        HashMap<Character, Frekvenssiolio> expResult = null;
        HashMap<Character, Frekvenssiolio> result = instance.laskeKirjaimet(teksti);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
