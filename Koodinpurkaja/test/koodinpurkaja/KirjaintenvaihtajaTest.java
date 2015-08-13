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
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("lol");
        String expResult = "lol";
        String result = instance.getTeksti();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTeksti method, of class Kirjaintenvaihtaja.
     */
    @Test
    public void testGetTeksti() {
        System.out.println("getTeksti");
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("lol");
        String expResult = "lol";
        String result = instance.getTeksti();
        assertEquals(expResult, result);
    }

 /**
     * Test of korvaa method, of class Salakoodi.
     */
    @Test
    public void testKorvaa() {
        System.out.println("korvaaUseampiKirjain");
        Character korvattava = 'a';
        Character korvaaja = 'b';
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
        Character korvattava = 'l';
        Character korvaaja = 'r';
        instance.korvaa(korvattava, korvaaja);
        korvattava = 'o';
        korvaaja = 'o';
        instance.korvaa(korvattava, korvaaja);
        korvattava = 'k';
        korvaaja = 'c';
        instance.korvaa(korvattava, korvaaja);
        korvattava = 'a';
        korvaaja = 'k';
        instance.korvaa(korvattava, korvaaja);
        
        String vastaus = instance.luePurettuKoodi();
        assertEquals("rock", vastaus);
    }
    
    @Test
    public void testKorvaaMuttaJataValilyonnitRauhaan() {
        System.out.println("korvaaJaJätäVälilyönnitRauhaan");
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("loka loka loka");
        Character korvattava = 'l';
        Character korvaaja = 'r';
        instance.korvaa(korvattava, korvaaja);
        korvattava = 'o';
        korvaaja = 'o';
        instance.korvaa(korvattava, korvaaja);
        korvattava = 'k';
        korvaaja = 'c';
        instance.korvaa(korvattava, korvaaja);
        korvattava = 'a';
        korvaaja = 'k';
        instance.korvaa(korvattava, korvaaja);
        
        String vastaus = instance.luePurettuKoodi();
        assertEquals("rock rock rock", vastaus);
    }

    /**
     * Test of luePurettuKoodi method, of class Kirjaintevaihtaja.
     */
    @Test
    public void testLuePurettuKoodi() {
        System.out.println("luePurettuKoodi");
        Character korvattava = 'a';
        Character korvaaja = 'b';
        Kirjaintenvaihtaja instance = new Kirjaintenvaihtaja();
        instance.setTeksti("aca");
        instance.korvaa(korvattava, korvaaja);
        String vastaus = instance.luePurettuKoodi();
        assertEquals("bcb", vastaus);
    }

}