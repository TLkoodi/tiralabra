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
public class MappiTest {

    public MappiTest() {
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
     * Test of add method, of class Mappi.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Comparable avain = 'A';
        Comparable arvo = 'B';
        Mappi instance = new Mappi();
        instance.put(avain, arvo);
        assertEquals('B', instance.get(avain));
    }

    /**
     * Test of get method, of class Mappi.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Comparable avain = 'A';
        Comparable arvo = 'B';
        Mappi instance = new Mappi();
        instance.put(avain, arvo);
        assertEquals('B', instance.get(avain));
    }

    @Test
    public void testGetNull() {
        System.out.println("get");
        Comparable avain = 'A';
        Comparable arvo = 'B';
        Mappi instance = new Mappi();
        instance.put(avain, arvo);
        assertEquals(null, instance.get('C'));
    }

    @Test
    public void testGetJosLaitetaankinEnemmanTavaraa() {
        System.out.println("get");
        Comparable avain = 'J';
        Comparable arvo = 'B';
        Mappi instance = new Mappi();
        instance.put(avain, arvo);
        instance.put('T', 'H');
        instance.put('A', 'H');
        instance.put('H', 'H');
        instance.put('K', 'H');
        instance.put('O', 'H');
        assertEquals('B', instance.get(avain));
    }

    @Test
    public void testGetJosLaitetaankinSamaAvain() {
        System.out.println("get");
        Comparable avain = 'J';
        Comparable arvo = 'B';
        Mappi instance = new Mappi();
        instance.put(avain, arvo);
        instance.put('T', 'H');
        instance.put('A', 'H');
        instance.put('H', 'H');
        instance.put('K', 'H');
        instance.put('O', 'H');
        instance.put('J', 'B');
        assertEquals('B', instance.get(avain));
    }

    @Test
    public void testClear() {
        System.out.println("get");
        Comparable avain = 'J';
        Comparable arvo = 'B';
        Mappi instance = new Mappi();
        instance.put(avain, arvo);
        instance.clear();
        assertEquals(null, instance.get(avain));
    }

    /**
     * Test of containsKey method, of class Mappi.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Mappi instance = new Mappi();
        instance.put('C', 'F');
        instance.put('D', 'F');
        instance.put('X', 'F');
        boolean expResult = true;
        boolean result = instance.containsKey('D');
        assertEquals(expResult, result);
    }

    /**
     * Test of containsKey method, of class Mappi.
     */
    @Test
    public void testContainsKeyFalse() {
        System.out.println("containsKey");
        Mappi instance = new Mappi();
        instance.put('C', 'F');
        instance.put('D', 'F');
        instance.put('X', 'F');
        boolean expResult = false;
        boolean result = instance.containsKey('U');
        assertEquals(expResult, result);
    }

    /**
     * Test of haeArvopariAvaimenPerusteella method, of class Mappi.
     */
    @Test
    public void testHaeArvopariAvaimenPerusteella() {
        System.out.println("haeArvopariAvaimenPerusteella");
        Comparable avain = 'R';
        Mappi instance = new Mappi();
        instance.put('G', 'T');
        instance.put('E', 'T');
        instance.put('H', 'T');
        instance.put(avain, 'V');
        Arvopari result = instance.haeArvopariAvaimenPerusteella(avain);
        assertEquals('V', result.getArvo());
    }

    @Test
    public void testHaeArvopariAvaimenPerusteellaNull() {
        System.out.println("haeArvopariAvaimenPerusteella");
        Comparable avain = 'R';
        Mappi instance = new Mappi();
        instance.put('G', 'T');
        instance.put('E', 'T');
        instance.put('H', 'T');
        Arvopari result = instance.haeArvopariAvaimenPerusteella(avain);
        assertEquals(null, result);
    }

    @Test
    public void testRemove() {
        Comparable avain = 'R';
        Mappi instance = new Mappi();
        instance.put('G', 'T');
        instance.put('E', 'T');
        instance.put('H', 'T');
        instance.put(avain, 'V');
        instance.remove(avain);
        Arvopari result = instance.haeArvopariAvaimenPerusteella(avain);
        assertEquals(null, result);
    }

    /**
     * Test of putValmisArvopariMappiin method, of class Mappi.
     */
    @Test
    public void testPutValmisArvopariMappiin() {
        System.out.println("putValmisArvopariMappiin");
        Arvopari pari = new Arvopari('C', 'D');
        Mappi instance = new Mappi();
        instance.put('R', 'A');
        instance.put('A', 'S');
        instance.putValmisArvopariMappiin(pari);
        assertEquals('D', instance.get('C'));
        
    }

    /**
     * Test of poistaSolmuJaLisaaSenSolmutUuudelleenMappiin method, of class Mappi.
     */
    @Test
    public void testPoistaSolmuJaLisaaSenSolmutUuudelleenMappiin() {
        System.out.println("poistaSolmuJaLisaaSenSolmutUuudelleenMappiin");
        Arvopari kasiteltava = new Arvopari('G', 'A');
        Mappi instance = new Mappi();
        instance.putValmisArvopariMappiin(kasiteltava);
        instance.put('H', 'B');
        instance.put('F', 'C');
        instance.remove('G');
        assertEquals(true, instance.containsKey('F'));
    }

    /**
     * Test of palautaAlinSolmuMahdollisimmanVasemmalta method, of class Mappi.
     */
    @Test
    public void testPalautaAlinSolmuMahdollisimmanVasemmalta() {
        System.out.println("palautaAlinSolmuMahdollisimmanVasemmalta");
        Mappi instance = new Mappi();
        instance.put('2', null);
        instance.put('3', null);
        instance.put('1', null);
        Arvopari result = instance.palautaAlinSolmuMahdollisimmanVasemmalta();
        assertEquals('3', result.getAvain());
        
    }
}
