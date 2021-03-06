package koodinpurkaja;

import koodinpurkaja.Tietorakenteet.LinkitettyLista;

/**
 * Tämä luokka toimii apuna hakiessa kielen kirjainten yleisyysjärjestystä. Luokkaa voi laajentaa vapaasti haluamilleen kielille.
 * @author Tony
 */
public class Frekvenssitiedot {
    
    /**
     * Tällä haetaan englannin kielen kirjaimet yleissyysjärjestyksessä.
     * @return Linkitetty lista merkeistä
     */
    public LinkitettyLista haeEnglanti(){
     LinkitettyLista jono = new LinkitettyLista();
     jono.add('e');
     jono.add('t');
     jono.add('a');
     jono.add('o');
     jono.add('i');
     jono.add('n');
     jono.add('s');
     jono.add('r');
     jono.add('h');
     jono.add('d');
     jono.add('l');
     jono.add('u');
     jono.add('c');
     jono.add('m');
     jono.add('f');
     jono.add('y');
     jono.add('w');
     jono.add('g');
     jono.add('p');
     jono.add('b');
     jono.add('v');
     jono.add('k');
     jono.add('x');
     jono.add('q');
     jono.add('j');
     jono.add('z');
     return jono;
    }
    
    
}
