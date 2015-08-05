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
public class KirjaintenvaihtajaTest {
    
    public KirjaintenvaihtajaTest() {
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
     * Test of setTeksti method, of class Kirjaintenvaihtaja.
     */
    @Test
    public void testSetTeksti() {
        System.out.println("setTeksti");
        String lisattava = "";
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti(lisattava);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeksti method, of class Kirjaintenvaihtaja.
     */
    @Test
    public void testGetTeksti() {
        System.out.println("getTeksti");
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        String expResult = "";
        String result = instance.getTeksti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 /**
     * Test of korvaa method, of class Salakoodi.
     */
    @Test
    public void testKorvaa() {
        System.out.println("korvaaUseampiKirjain");
        String korvattava = "a";
        String korvaaja = "b";
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("aca");
        instance.korvaa(korvattava, korvaaja);
        String vastaus = instance.luePurettuKoodi();
        assertEquals("bcb", vastaus);
    }
    
   @Test
    public void testKorvaaUseampiKirjain() {
        System.out.println("korvaa");
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("loka");
        String korvattava = "l";
        String korvaaja = "r";
        instance.korvaa(korvattava, korvaaja);
        korvattava = "o";
        korvaaja = "o";
        instance.korvaa(korvattava, korvaaja);
        korvattava = "k";
        korvaaja = "c";
        instance.korvaa(korvattava, korvaaja);
        korvattava = "a";
        korvaaja = "k";
        instance.korvaa(korvattava, korvaaja);
        
        String vastaus = instance.luePurettuKoodi();
        assertEquals("rock", vastaus);
    }
    
    @Test
    public void testKorvaaMuttaJataValilyonnitRauhaan() {
        System.out.println("korvaaJaJätäVälilyönnitRauhaan");
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("loka loka loka");
        String korvattava = "l";
        String korvaaja = "r";
        instance.korvaa(korvattava, korvaaja);
        korvattava = "o";
        korvaaja = "o";
        instance.korvaa(korvattava, korvaaja);
        korvattava = "k";
        korvaaja = "c";
        instance.korvaa(korvattava, korvaaja);
        korvattava = "a";
        korvaaja = "k";
        instance.korvaa(korvattava, korvaaja);
        
        String vastaus = instance.luePurettuKoodi();
        assertEquals("rock rock rock", vastaus);
    }

    /**
     * Test of luePurettuKoodi method, of class Salakoodi.
     */
    @Test
    public void testLuePurettuKoodi() {
        System.out.println("luePurettuKoodi");
        String korvattava = "a";
        String korvaaja = "b";
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("aca");
        instance.korvaa(korvattava, korvaaja);
        String vastaus = instance.luePurettuKoodi();
        assertEquals("bcb", vastaus);
    }
}
