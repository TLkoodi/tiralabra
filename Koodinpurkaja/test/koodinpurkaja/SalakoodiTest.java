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
        Salakoodi instance = new Salakoodi();
        instance.lisaaTeksti(lisattava);
        String teksti = instance.lueTeksti();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("justjust", teksti);
    }

    /**
     * Test of lueTeksti method, of class Salakoodi.
     */
    @Test
    public void testLueTeksti() {
        System.out.println("lueTeksti");
        Salakoodi instance = new Salakoodi();
        String lisataan = "juupajuu";
        instance.lisaaTeksti(lisataan);
        String result = instance.lueTeksti();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("juupajuu", result);
    }

    /**
     * Test of korvaa method, of class Salakoodi.
     */
    @Test
    public void testKorvaa() {
        System.out.println("korvaaUseampiKirjain");
        String korvattava = "a";
        String korvaaja = "b";
        Salakoodi instance = new Salakoodi();
        instance.lisaaTeksti("aca");
        instance.korvaa(korvattava, korvaaja);
        String vastaus = instance.luePurettuKoodi();
        assertEquals("bcb", vastaus);
    }
    
   @Test
    public void testKorvaaUseampiKirjain() {
        System.out.println("korvaa");
        Salakoodi instance = new Salakoodi();
        instance.lisaaTeksti("loka");
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
        Salakoodi instance = new Salakoodi();
        instance.lisaaTeksti("loka loka loka");
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
        Salakoodi instance = new Salakoodi();
        instance.lisaaTeksti("aca");
        instance.korvaa(korvattava, korvaaja);
        String vastaus = instance.luePurettuKoodi();
        assertEquals("bcb", vastaus);
    }
    
}
