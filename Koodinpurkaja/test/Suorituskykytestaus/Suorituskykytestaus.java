/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suorituskykytestaus;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;
import koodinpurkaja.Tietorakenteet.LinkitettyLista;
import koodinpurkaja.Tietorakenteet.Mappi;
import koodinpurkaja.Tietorakenteet.PriorisoituJono;
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
public class Suorituskykytestaus {
    
    public Suorituskykytestaus() {
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
    
    // NÄISTÄ VOI KOMMENTOINNIN POISTAA JOS HALUAA AJAA, AJO KESTÄÄ AIKA KAUAN JOTEN SEN TAKIA KOMMENTOITU POIS.
    
     @Test
    public void testPut100() {
        long aikaAlussa = System.currentTimeMillis();
        System.out.println("Verrataan 100 put operaatio mappeihin");
        Mappi instance = new Mappi();
        int i = 0;
        while (i < 100){
            instance.put(i, i);
            i++;
        }
        long aikaLopussa = System.currentTimeMillis();
        System.out.println("Mappi put 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
        aikaAlussa = System.currentTimeMillis();
        TreeMap instance2 = new TreeMap();
        i = 0;
        while (i < 100){
            instance2.put(i, i);
            i++;
        }
        aikaLopussa = System.currentTimeMillis();
        System.out.println("TreeMap put 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
        assertEquals(true, true);
    }
//
//    @Test
//    public void testPut1000() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 1000 put operaatio mappeihin");
//        Mappi instance = new Mappi();
//        int i = 0;
//        while (i < 1000){
//            instance.put(i, i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("Mappi put 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        TreeMap instance2 = new TreeMap();
//        i = 0;
//        while (i < 1000){
//            instance2.put(i, i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("TreeMap put 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//    @Test
//    public void testPut10000() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 10000 put operaatio mappeihin");
//        Mappi instance = new Mappi();
//        int i = 0;
//        while (i < 10000){
//            instance.put(i, i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("Mappi put 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        TreeMap instance2 = new TreeMap();
//        i = 0;
//        while (i < 10000){
//            instance2.put(i, i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("TreeMap put 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//  
//    
//    @Test
//    public void testRemove100() {
//        
//        System.out.println("Verrataan 100 remove operaatio mappeihin");
//        Mappi instance = new Mappi();
//        int i = 0;
//        while (i < 100){
//            instance.put(i, i);
//            i++;
//        }
//        long aikaAlussa = System.currentTimeMillis();
//        i = 0;
//        while (i < 100){
//            instance.remove(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("Mappi remove 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        TreeMap instance2 = new TreeMap();
//        i = 0;
//        while (i < 100){
//            instance2.put(i, i);
//            i++;
//        }
//        aikaAlussa = System.currentTimeMillis();
//        i = 0;
//        while (i < 100){
//            instance2.remove(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("TreeMap remove 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//    @Test
//    public void testRemove1000() {
//        
//        System.out.println("Verrataan 1000 remove operaatio mappeihin");
//        Mappi instance = new Mappi();
//        int i = 0;
//        while (i < 1000){
//            instance.put(i, i);
//            i++;
//        }
//        long aikaAlussa = System.currentTimeMillis();
//        i = 0;
//        while (i < 1000){
//            instance.remove(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("Mappi remove 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        TreeMap instance2 = new TreeMap();
//        i = 0;
//        while (i < 1000){
//            instance2.put(i, i);
//            i++;
//        }
//        aikaAlussa = System.currentTimeMillis();
//        i = 0;
//        while (i < 1000){
//            instance2.remove(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("TreeMap remove 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//    @Test
//    public void testRemove10000() {
//        
//        System.out.println("Verrataan 10000 remove operaatio mappeihin");
//        Mappi instance = new Mappi();
//        int i = 0;
//        while (i < 10000){
//            instance.put(i, i);
//            i++;
//        }
//        long aikaAlussa = System.currentTimeMillis();
//        i = 0;
//        while (i < 10000){
//            instance.remove(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("Mappi remove 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        TreeMap instance2 = new TreeMap();
//        i = 0;
//        while (i < 10000){
//            instance2.put(i, i);
//            i++;
//        }
//        aikaAlussa = System.currentTimeMillis();
//        i = 0;
//        while (i < 10000){
//            instance2.remove(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("TreeMap remove 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//        @Test
//    public void testAdd100() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 100 add operaatio listoihin");
//        LinkitettyLista instance = new LinkitettyLista();
//        int i = 0;
//        while (i < 100){
//            instance.add(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("linkitettyLista add 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        LinkedList instance2 = new LinkedList();
//        i = 0;
//        while (i < 100){
//            instance2.add(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("LinkedList add 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//     @Test
//    public void testAdd1000() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 1000 add operaatio listoihin");
//        LinkitettyLista instance = new LinkitettyLista();
//        int i = 0;
//        while (i < 1000){
//            instance.add(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("linkitettyLista add 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        LinkedList instance2 = new LinkedList();
//        i = 0;
//        while (i < 1000){
//            instance2.add(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("LinkedList add 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//     @Test
//    public void testAdd10000() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 10000 add operaatio listoihin");
//        LinkitettyLista instance = new LinkitettyLista();
//        int i = 0;
//        while (i < 10000){
//            instance.add(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("linkitettyLista add 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        LinkedList instance2 = new LinkedList();
//        i = 0;
//        while (i < 10000){
//            instance2.add(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("LinkedList add 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//        @Test
//        
//    public void testAddX100() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 100 add operaatio listoihin");
//        PriorisoituJono instance = new PriorisoituJono();
//        int i = 0;
//        while (i < 100){
//            instance.add(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("PriorisoituJono add 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        PriorityQueue instance2 = new PriorityQueue();
//        i = 0;
//        while (i < 100){
//            instance2.add(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("LinkedList add 100 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//     @Test
//    public void testAddX1000() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 1000 add operaatio listoihin");
//        PriorisoituJono instance = new PriorisoituJono();
//        int i = 0;
//        while (i < 1000){
//            instance.add(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("PriorisoituJono add 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        PriorityQueue instance2 = new PriorityQueue();
//        i = 0;
//        while (i < 1000){
//            instance2.add(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("LinkedList add 1000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
//    
//     @Test
//    public void testAddX10000() {
//        long aikaAlussa = System.currentTimeMillis();
//        System.out.println("Verrataan 10000 add operaatio listoihin");
//        PriorisoituJono instance = new PriorisoituJono();
//        int i = 0;
//        while (i < 10000){
//            instance.add(i);
//            i++;
//        }
//        long aikaLopussa = System.currentTimeMillis();
//        System.out.println("PriorisoituJono add 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        aikaAlussa = System.currentTimeMillis();
//        PriorityQueue instance2 = new PriorityQueue();
//        i = 0;
//        while (i < 10000){
//            instance2.add(i);
//            i++;
//        }
//        aikaLopussa = System.currentTimeMillis();
//        System.out.println("LinkedList add 10000 operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
//        assertEquals(true, true);
//    }
}
