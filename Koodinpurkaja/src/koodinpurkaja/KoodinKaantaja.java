
package koodinpurkaja;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Tony
 */
public class KoodinKaantaja {
    private Frekvenssitiedot sanakirja = new Frekvenssitiedot();
    private LinkedList yleisyystiedot = new LinkedList();
    private String kelpuutetutKirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
    
    /**
     * Metodi hakee ensin Frekvnssitiedot-luokasta tiedot halutun kielen yleisimmistä kirjaimista järjestyksessä,
     * jotta niillä voidaan lähteä korvaamaan syötteenä saadun tekstin kirjaimia yleisyysjärjestyksessä.
     * 
     * Tämän jälkeen metodi lähtettää Analysoija-luokalle tekstin jonka kirjaimet ja niiden esiintyvyys laksetaan.
     * 
     * Sitten metodi systemaattisesti järjestyksessä korvaa alkuperäisen tekstin kirjaimet yleisyysjärjestyksessä, käyttäen korvaamiseen
     * kirjaintenvaihtaja-luokkaa. Metodi hyväksyy korvattaviksi merkeiksi vain merkit jotka on sisällytetty luokan muuttujaan "kelpuutetutKirjaimet".
     * 
     *
     * @param teksti tämä parametri on teksti jonka halutaan analysoitavan ja käännettävän salakielestä todelliseksi kieleksi
     * @return paluuarvona on käännetty teksti
     */
    public String kaanna(String teksti){
       yleisyystiedot = sanakirja.haeEnglanti();
       
       Analysoija analysoija = new Analysoija();
       
       PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = analysoija.analysoiFrekvenssi(teksti);
       
       Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();
       
       kirjaintenvaihtaja.setTeksti(teksti);
       
       while (!yleisyystiedot.isEmpty() && !tekstinKirjaintiedot.isEmpty()){
       //    System.out.println("Korvataan: " + tekstinKirjaintiedot.peek().getKoodi() + " kirjaimella " + yleisyystiedot.peek());
           if (kelpuutetutKirjaimet.contains(tekstinKirjaintiedot.peek().getKoodi().toString())){
           kirjaintenvaihtaja.korvaa(tekstinKirjaintiedot.poll().getKoodi().toString(), yleisyystiedot.poll().toString());
           } else {
               tekstinKirjaintiedot.poll();
           }
       }
       
       return kirjaintenvaihtaja.luePurettuKoodi();
    }
}
