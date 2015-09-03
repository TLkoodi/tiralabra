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
public class ArvopariTest {
    
    public ArvopariTest() {
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
     * Test of getArvo method, of class Arvopari.
     */
    @Test
    public void testGetArvo() {
        System.out.println("getArvo");
        Character arvo = 'A';
        Arvopari instance = new Arvopari('F','D');
        instance.setArvo(arvo);
        assertEquals('A', instance.getArvo());
    }

    /**
     * Test of getAvain method, of class Arvopari.
     */
    @Test
    public void testGetAvain() {
        System.out.println("getAvain");
        Character arvo = 'A';
        Arvopari instance = new Arvopari('F','D');
        instance.setAvain(arvo);
        assertEquals('A', instance.getAvain());
    }

    /**
     * Test of setArvo method, of class Arvopari.
     */
    @Test
    public void testSetArvo() {
        System.out.println("setArvo");
        Character arvo = 'A';
        Arvopari instance = new Arvopari('F','D');
        instance.setArvo(arvo);
        assertEquals('A', instance.getArvo());
    }

    /**
     * Test of setAvain method, of class Arvopari.
     */
    @Test
    public void testSetAvain() {
        System.out.println("setAvain");
        Character arvo = 'A';
        Arvopari instance = new Arvopari('F','D');
        instance.setAvain(arvo);
        assertEquals('A', instance.getAvain());
    }

    /**
     * Test of setNextVasen method, of class Arvopari.
     */
    @Test
    public void testSetNextVasen() {
        System.out.println("setNextVasen");
        Arvopari nextpari = new Arvopari('F','D');
        nextpari.setAvain('U');
        Arvopari instance = new Arvopari('F','D');
        instance.setNextVasen(nextpari);
        assertEquals('U', instance.getNextVasen().getAvain());
    }

    /**
     * Test of setNextOikea method, of class Arvopari.
     */
    @Test
    public void testSetNextOikea() {
        System.out.println("setNextOikea");
         Arvopari nextpari = new Arvopari('F','D');
        nextpari.setAvain('U');
        Arvopari instance = new Arvopari('F','D');
        instance.setNextOikea(nextpari);
        assertEquals('U', instance.getNextOikea().getAvain());
    }

    /**
     * Test of getNextVasen method, of class Arvopari.
     */
    @Test
    public void testGetNextVasen() {
        System.out.println("getNextVasen");
         Arvopari nextpari = new Arvopari('F','D');
        nextpari.setAvain('U');
        Arvopari instance = new Arvopari('F','D');
        instance.setNextVasen(nextpari);
        assertEquals('U', instance.getNextVasen().getAvain());
    }

    /**
     * Test of getNextOikea method, of class Arvopari.
     */
    @Test
    public void testGetNextOikea() {
        System.out.println("getNextOikea");
         Arvopari nextpari = new Arvopari('F','D');
        nextpari.setAvain('U');
        Arvopari instance = new Arvopari('F','D');
        instance.setNextOikea(nextpari);
        assertEquals('U', instance.getNextOikea().getAvain());
    }
    
}
