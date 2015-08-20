/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodinpurkaja;

import koodinpurkaja.Tietorakenteet.Frekvenssiolio;
import java.util.LinkedList;
import java.util.PriorityQueue;
import koodinpurkaja.Tietorakenteet.LinkitettyLista;
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
        instance.setKaannettava("lol");
        String kaannos = instance.kaanna();
        assertEquals("ete", kaannos);
        
    }
    
    @Test
    public void testKaannaPariKertaaVaihtaenManuaalisestiValissa() {
        System.out.println("kaanna");
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.setKaannettava("lol");
        String kaannos = "";
        instance.kaanna();
        instance.vaihdaKirjainManuaalisesti("t", "l");
        instance.kaanna();
        instance.vaihdaKirjainManuaalisesti("e", "a");
        kaannos = instance.kaanna();
        assertEquals("ala", kaannos);
        
    }
    
    @Test
    public void testKaannaIlmanAsetettuaTekstia() {
        System.out.println("kaanna");
        KoodinKaantaja instance = new KoodinKaantaja();
        String kaannos = instance.kaanna();
        assertEquals(null, kaannos);
        
    }

    /**
     * Test of setKaannettava method, of class KoodinKaantaja.
     */
    @Test
    public void testSetKaannettava() {
        System.out.println("setKaannettava");
        String teksti = "heh";
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.setKaannettava(teksti);
        assertEquals(teksti, instance.getKaannettava());
    }

    /**
     * Test of getKaannettava method, of class KoodinKaantaja.
     */
    @Test
    public void testGetKaannettava() {
        System.out.println("getKaannettava");
        String teksti = "heh";
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.setKaannettava(teksti);
        assertEquals(teksti, instance.getKaannettava());
    }

    /**
     * Test of pidaKirjain method, of class KoodinKaantaja.
     */
    @Test
    public void testPidaKirjain() {
        System.out.println("pidaKirjain");
        String kirjainStringi = "z";
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.setKaannettava("lolz");
        instance.pidaKirjain(kirjainStringi);
        String expResult = "etez";
        assertEquals(expResult, instance.kaanna());
    }

    /**
     * Test of vaihdaKirjain method, of class KoodinKaantaja.
     */
    @Test
    public void testVaihdaKirjainManuaalisesti() {
        System.out.println("vaihdaKirjain");
        String vaihdettavaKirjainStringi = "o";
        String korvaavaKirjainStringi = "z";
        KoodinKaantaja instance = new KoodinKaantaja();
        String expResult = "zez";
        instance.setKaannettava("oho");
        instance.vaihdaKirjainManuaalisesti(vaihdettavaKirjainStringi, korvaavaKirjainStringi);
        assertEquals(expResult, instance.kaanna());
    }
    
    @Test
    public void testiVaihdaKirjainTuleekoBooleanOikein() {
        System.out.println("vaihdaKirjain");
        String vaihdettavaKirjainStringi = "o";
        String korvaavaKirjainStringi = "z";
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.setKaannettava("oho");
        boolean kuittaus = instance.vaihdaKirjainManuaalisesti(vaihdettavaKirjainStringi, korvaavaKirjainStringi);
        assertEquals(true, kuittaus);
    }
    
    @Test
    public void testiVaihdaKirjainTuleekoBooleanOikeinFalsena() {
        System.out.println("vaihdaKirjain");
        String vaihdettavaKirjainStringi = null;
        String korvaavaKirjainStringi = "z";
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.setKaannettava("oho");
        boolean kuittaus = instance.vaihdaKirjainManuaalisesti(vaihdettavaKirjainStringi, korvaavaKirjainStringi);
        assertEquals(false, kuittaus);
    }
    
    @Test
    public void testVaihdaKirjainNiinEttaKorvaajaKirjaimellaEiOleValmiiksiEsiintyvyyttaTekstissa() {
        String vaihdettavaKirjainStringi = "m";
        String korvaavaKirjainStringi = "e";
        KoodinKaantaja instance = new KoodinKaantaja();
        String expResult = "eee";
        instance.setKaannettava("mee");
        instance.vaihdaKirjainManuaalisesti(vaihdettavaKirjainStringi, korvaavaKirjainStringi);
        System.out.println(instance.kaanna());
        assertEquals(!expResult.equals(instance.kaanna()), true);
    }

    /**
     * Test of stringiKirjaimeksi method, of class KoodinKaantaja.
     */
    @Test
    public void testStringiKirjaimeksi() {
        System.out.println("stringiKirjaimeksi");
        String kirjainStringi = "K";
        KoodinKaantaja instance = new KoodinKaantaja();
        Character expResult = 'K';
        Character result = instance.stringiKirjaimeksi(kirjainStringi);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStringiKirjaimeksiLiianPitkallaStringilla() {
        System.out.println("stringiKirjaimeksi");
        String kirjainStringi = "KK";
        KoodinKaantaja instance = new KoodinKaantaja();
        Character expResult = null;
        Character result = instance.stringiKirjaimeksi(kirjainStringi);
        assertEquals(expResult, result);
    }

    /**
     * Test of poistaListaltaLukitutKirjaimet method, of class KoodinKaantaja.
     */
    @Test
    public void testPoistaListaltaLukitutKirjaimet() {
        System.out.println("poistaListaltaLukitutKirjaimet");
      //  LinkedList<Character> lista = new LinkedList<Character>();
        LinkitettyLista lista = new LinkitettyLista();
        lista.add('B');
        lista.add('D');
        lista.add('E');
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.pidaKirjain("D");
        //LinkedList<Character> result = instance.poistaListaltaLukitutKirjaimet(lista);
        LinkitettyLista result = instance.poistaListaltaLukitutKirjaimet(lista);
        assertEquals(false, result.contains('D'));
    }
    
    /**
     * Test of poistaListaltaLukitutKirjaimet method, of class KoodinKaantaja.
     */
    @Test
    public void testPoistaListaltaLukitutKirjaimetMuttaSaastaMuut() {
        System.out.println("poistaListaltaLukitutKirjaimetMuttaSaastaMuut");
      //  LinkedList<Character> lista = new LinkedList<Character>();
        LinkitettyLista lista = new LinkitettyLista();
        lista.add('B');
        lista.add('D');
        lista.add('E');
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.pidaKirjain("D");
        //LinkedList<Character> result = instance.poistaListaltaLukitutKirjaimet(lista);
        LinkitettyLista result = instance.poistaListaltaLukitutKirjaimet(lista);
        result.poll();
        assertEquals('E', result.poll());
    }

    /**
     * Test of vaihdaKirjainIlmanLukitusta method, of class KoodinKaantaja.
     */
    @Test
    public void testVaihdaKirjainIlmanLukitusta() {
        System.out.println("vaihdaKirjain");
        String vaihdettavaKirjainStringi = "o";
        String korvaavaKirjainStringi = "z";
        KoodinKaantaja instance = new KoodinKaantaja();
        String expResult = "zez";
        instance.setKaannettava("oho");
        instance.vaihdaKirjainManuaalisesti(vaihdettavaKirjainStringi, korvaavaKirjainStringi);
        assertEquals(expResult, instance.kaanna());
    }

    /**
     * Test of korvaaTekstinYleisimmatKirjaimet method, of class KoodinKaantaja.
     */
    @Test
    public void testKorvaaTekstinKirjaimet() {
        System.out.println("korvaaTekstinYleisimmatKirjaimet");
        LinkitettyLista yleisyystiedot = new LinkitettyLista();
        yleisyystiedot.add('a');
        yleisyystiedot.add('b');
        yleisyystiedot.add('c');
        yleisyystiedot.add('d');
        Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();
        kirjaintenvaihtaja.setTeksti("kissakassa");
        PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = new PriorityQueue<Frekvenssiolio>();
        Analysoija analysoija = new Analysoija();
        tekstinKirjaintiedot = analysoija.analysoiFrekvenssi("kissakassa");        
        KoodinKaantaja instance = new KoodinKaantaja();
        Kirjaintenvaihtaja result = instance.korvaaTekstinKirjaimet(yleisyystiedot, kirjaintenvaihtaja, tekstinKirjaintiedot);
        assertEquals("cdaabcbaab", result.luePurettuKoodi());
    }
    
    @Test
    public void testKorvaaTekstinYleisimmatKirjaimetMuttaAlaKorvaaLukittuja() {
        System.out.println("korvaaTekstinYleisimmatKirjaimet");
        LinkitettyLista yleisyystiedot = new LinkitettyLista();
        yleisyystiedot.add('a');
        yleisyystiedot.add('b');
        yleisyystiedot.add('c');
        yleisyystiedot.add('d');
        yleisyystiedot.add('e');
        Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();
        kirjaintenvaihtaja.setTeksti("kissakassa");
        PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = new PriorityQueue<Frekvenssiolio>();
        Analysoija analysoija = new Analysoija();
        tekstinKirjaintiedot = analysoija.analysoiFrekvenssi("kissakassa");        
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.pidaKirjain("a");
        Kirjaintenvaihtaja result = instance.korvaaTekstinKirjaimet(yleisyystiedot, kirjaintenvaihtaja, tekstinKirjaintiedot);
        assertEquals("cdbbacabba", result.luePurettuKoodi());
    }
    
    @Test
    public void testKorvaaTekstinYleisimmatKirjaimetMuttaAlaKorvaaAsetettujaKirjainvaihtoja() {
        System.out.println("korvaaTekstinYleisimmatKirjaimet");
        LinkitettyLista yleisyystiedot = new LinkitettyLista();
        yleisyystiedot.add('a');
        yleisyystiedot.add('b');
        yleisyystiedot.add('c');
        yleisyystiedot.add('d');
        yleisyystiedot.add('e');
        Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();
        kirjaintenvaihtaja.setTeksti("kissakassa");
        PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = new PriorityQueue<Frekvenssiolio>();
        Analysoija analysoija = new Analysoija();
        tekstinKirjaintiedot = analysoija.analysoiFrekvenssi("kissakassa");        
        KoodinKaantaja instance = new KoodinKaantaja();
        instance.vaihdaKirjainIlmanLukitusta("i", "a");
        Kirjaintenvaihtaja result = instance.korvaaTekstinKirjaimet(yleisyystiedot, kirjaintenvaihtaja, tekstinKirjaintiedot);
        assertEquals("dabbcdcbbc", result.luePurettuKoodi());
    }
    
}
