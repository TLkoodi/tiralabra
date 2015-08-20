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
public class LinkitettyListaTest {
    
    public LinkitettyListaTest() {
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
     * Test of add method, of class LinkitettyLista.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object tieto = 'P';
        LinkitettyLista instance = new LinkitettyLista();
        instance.add(tieto);
        assertEquals('P', instance.poll());
    }
    
    /**
     * Test of add method, of class LinkitettyLista. But lets add some more.
     */
    @Test
    public void testAddSomeMore() {
        System.out.println("addSomeMore");
        Object tieto = 'P';
        LinkitettyLista instance = new LinkitettyLista();
        instance.add('F');
        instance.add('E');
        instance.add('D');
        instance.add('E');
        instance.add('R');
        instance.add('A');
        instance.add('L');
        instance.add(tieto);
        instance.poll();
        instance.poll();
        instance.poll();
        instance.poll();
        instance.poll();
        instance.poll();
        instance.poll();
        assertEquals('P', instance.poll());
    }

    /**
     * Test of poll method, of class LinkitettyLista.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        Object tieto = 'P';
        LinkitettyLista instance = new LinkitettyLista();
        instance.add(tieto);
        instance.add('F');
        instance.poll();
        assertEquals('F', instance.poll());
    }
    
    @Test
    public void testPeek() {
        System.out.println("peek");
        Object tieto = 'P';
        LinkitettyLista instance = new LinkitettyLista();
        instance.add(tieto);
        instance.add('F');
        assertEquals('P', instance.peek());
    }
    
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Object tieto = 'P';
        LinkitettyLista instance = new LinkitettyLista();
        instance.add(tieto);
        instance.poll();
        assertEquals(null, instance.poll());
    }
    
    @Test
    public void testIsEmptyIlmanAsetettuaTietoa() {
        System.out.println("isEmptyIlmanAsetettuaTietoa");
        LinkitettyLista instance = new LinkitettyLista();
        assertEquals(null, instance.poll());
    }
    
    @Test
    public void contains() {
        System.out.println("contains");
        LinkitettyLista instance = new LinkitettyLista();
        instance.add('P');
        instance.add('O');
        instance.add('?');
        instance.add('F');
        assertEquals(true, instance.contains('?'));
    }
    
    @Test
    public void containsEipaSisallakkaan() {
        System.out.println("contains");
        LinkitettyLista instance = new LinkitettyLista();
        instance.add('P');
        instance.add('O');
        instance.add('?');
        instance.add('F');
        assertEquals(false, instance.contains('M'));
    }
    
    @Test
    public void testClone() {
        System.out.println("clone");
        LinkitettyLista instance = new LinkitettyLista();
        LinkitettyLista klooni = instance.clone();
        assertEquals(false, instance.equals(klooni));
    }
    
    @Test
    public void testCloneOnkoEkaObjectiSama() {
        System.out.println("clone");
        LinkitettyLista instance = new LinkitettyLista();
        instance.add('E');
        LinkitettyLista klooni = instance.clone();
        assertEquals('E', klooni.peek());
    }
    
    @Test
    public void testCloneOnkoVikaObjectiSama() {
        System.out.println("clone");
        LinkitettyLista instance = new LinkitettyLista();
        
        instance.add('E');
        instance.add('F');
        instance.add('G');
        LinkitettyLista klooni = instance.clone();
        klooni.poll();
        klooni.poll();
        assertEquals('G', klooni.peek());
    }
    
    @Test
    public void testCloneEikaiKloonattavaTyhjentynyt() {
        System.out.println("clone");
        LinkitettyLista instance = new LinkitettyLista();
        
        instance.add('E');
        instance.add('F');
        instance.add('G');
        LinkitettyLista klooni = instance.clone();
        assertEquals(false, instance.isEmpty());
    }
    
}
