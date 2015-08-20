/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja.Tietorakenteet;

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
public class SolmuTest {
    
    public SolmuTest() {
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
     * Test of setNextSolmu method, of class Solmu.
     */
    @Test
    public void testSetNextSolmu() {
        System.out.println("setNextSolmu");
        String teksti = "lolzorr";
        Solmu seuraavaSolmu = new Solmu(teksti);
        Solmu instance = new Solmu("jotain");
        instance.setNextSolmu(seuraavaSolmu);
        assertEquals("lolzorr", instance.getNextSolmu().getTieto());
    }

    /**
     * Test of setPreviousSolmu method, of class Solmu.
     */
    @Test
    public void testSetPreviousSolmu() {
        System.out.println("setPreviousSolmu");
        Solmu edellinenSolmu = new Solmu ("wlanonparas");
        Solmu instance = new Solmu("Eipäskuinjohtojuttu");
        instance.setPreviousSolmu(edellinenSolmu);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("wlanonparas", instance.getPreviousSolmu().getTieto());
    }

    /**
     * Test of getNextSolmu method, of class Solmu.
     */
    @Test
    public void testGetNextSolmu() {
        System.out.println("getNextSolmu");
        String teksti = "lolzorr";
        Solmu seuraavaSolmu = new Solmu(teksti);
        Solmu instance = new Solmu("jotain");
        instance.setNextSolmu(seuraavaSolmu);
        assertEquals("lolzorr", instance.getNextSolmu().getTieto());
    }

    /**
     * Test of getPreviousSolmu method, of class Solmu.
     */
    @Test
    public void testGetPreviousSolmu() {
        System.out.println("getPreviousSolmu");
        Solmu edellinenSolmu = new Solmu ("wlanonparas");
        Solmu instance = new Solmu("Eipäskuinjohtojuttu");
        instance.setPreviousSolmu(edellinenSolmu);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("wlanonparas", instance.getPreviousSolmu().getTieto());
    }

    /**
     * Test of getTieto method, of class Solmu.
     */
    @Test
    public void testGetTieto() {
        System.out.println("getTieto");
        Solmu instance = new Solmu ("testataanpasStringi");
        String teksti = "testataanpasStringi";
        Object result = instance.getTieto();
        assertEquals(teksti, result);
    }
    
    @Test
    public void testGetTietoCharacterilla() {
        System.out.println("getTietoCharacterilla");
        Solmu instance = new Solmu ('K');
        Character kirjain = 'K';
        Object result = instance.getTieto();
        assertEquals(kirjain, result);
    }
    
}
