package koodinpurkaja;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Tony
 */
public class KoodinKaantaja {

    private Frekvenssitiedot sanakirja = new Frekvenssitiedot();
    private String kelpuutetutKirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
    private Analysoija analysoija = new Analysoija();
    public TreeSet<Character> lukituslista = new TreeSet<Character>();
    public TreeMap<Character, Character> kirjaintenVaihdot = new TreeMap<Character, Character>();
    public String kaannettava;

    /**
     * Setteri käännettävälle tekstille
     *
     * @param kaannettava käännettävä teksti
     */
    public void setKaannettava(String teksti) {
        this.kaannettava = teksti;
    }

    public String getKaannettava() {
        return kaannettava;
    }

    /**
     * Metodi hakee ensin Frekvnssitiedot-luokan ilmentymästä "sanakirja" tiedot halutun kielen
     * yleisimmistä kirjaimista järjestyksessä, jotta niillä voidaan lähteä
     * korvaamaan syötteenä saadun tekstin kirjaimia yleisyysjärjestyksessä.
     *
     * Tämän jälkeen metodi lähtettää Analysoija-luokalle tekstin jonka
     * kirjaimet ja niiden esiintyvyys laksetaan.
     *
     * Seuraavaksi suoritetaan ennalta määrätyt kirjainten vaihtamiset, jos luokalle on annettu kirjaintenVaihdot-TreeMappiin ohjeet 
     * mitkä kirjaimet korvataan millä. Kirjaimet vaihdetaan käyttämällä kirjaintenvaihtaja-luokkaa.
     * 
     * Sitten metodi systemaattisesti järjestyksessä korvaa alkuperäisen tekstin
     * kirjaimet yleisyysjärjestyksessä niiltä osin kun kirjaimia ei ole lukittu tai erikseen asettamalla vaihdettu.
     * Apuna korvaamiseen käytetään kirjaintenvaihtaja-luokkaa. Metodi hyväksyy korvattaviksi merkeiksi vain
     * merkit jotka on sisällytetty luokan muuttujaan "kelpuutetutKirjaimet".
     * 
     * Metodi tekee tällä hetkellä useassa palassa käännöstyön, joten tätä metodia tulen pilkkomaan vielä osiin omikse metodeikseen.
     *
     *
     * @param teksti tämä parametri on teksti jonka halutaan analysoitavan ja
     * käännettävän salakielestä todelliseksi kieleksi
     * @return paluuarvona on käännetty teksti
     */
    public String kaanna() {
        if (kaannettava == null) {
            return null;
        }

        LinkedList<Character> yleisyystiedot = new LinkedList<Character>();
        yleisyystiedot = sanakirja.haeEnglanti();

        Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();

        PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = analysoija.analysoiFrekvenssi(kaannettava);

        kirjaintenvaihtaja.setTeksti(kaannettava);

        yleisyystiedot = poistaListaltaLukitutKirjaimet(yleisyystiedot);
        LinkedList<Character> yleisyystiedotKlooni = (LinkedList<Character>)yleisyystiedot.clone();

        final Set<Map.Entry<Character, Character>> kirjainVaihdot = kirjaintenVaihdot.entrySet();
        for (Map.Entry<Character, Character> korvaus : kirjainVaihdot) {
            if (kelpuutetutKirjaimet.contains(korvaus.getValue().toString())) {
                kirjaintenvaihtaja.korvaa(korvaus.getValue(), yleisyystiedotKlooni.poll());
            }
        }
        
        String valikaannos = kirjaintenvaihtaja.luePurettuKoodi();
        kirjaintenvaihtaja.setTeksti(valikaannos);

        while (!yleisyystiedot.isEmpty() && !tekstinKirjaintiedot.isEmpty()) {
            Character korvattava = tekstinKirjaintiedot.peek().getKoodi();
            Character korvaaja = yleisyystiedot.peek();

            if (lukituslista.contains(korvaaja) || kirjaintenVaihdot.containsValue(korvaaja)) {
                yleisyystiedot.poll();

            } else if (lukituslista.contains(korvattava)) {
                tekstinKirjaintiedot.poll();

            } else if (kirjaintenVaihdot.containsKey(korvattava)) {
                kirjaintenvaihtaja.korvaa(korvattava, kirjaintenVaihdot.get(korvattava));
                tekstinKirjaintiedot.poll();

            } else if (kelpuutetutKirjaimet.contains(korvattava.toString())) {
                kirjaintenvaihtaja.korvaa(korvattava, yleisyystiedot.poll());
                tekstinKirjaintiedot.poll();

            } else {
                tekstinKirjaintiedot.poll();
            }
        }
        kaannettava = kirjaintenvaihtaja.luePurettuKoodi();
        kirjaintenVaihdot.clear();
        return kaannettava;
    }
    
    /**
     * Metodi poistaa sille annetusta linkitetystä listasta kaikki ne merkit, mitkä on lisätty lukituslista-muuttujaan.
     * Tämän jälkeen lista palautetaan takaisin.
     * 
     * @param lista muokattava lista
     * @return lista josta on poiistettu lukituslista-muuttujan merkit
     */

    public LinkedList<Character> poistaListaltaLukitutKirjaimet(LinkedList<Character> lista) {
        LinkedList<Character> uusiLista = new LinkedList<Character>();
        while (!lista.isEmpty()) {
            Character kirjain = lista.poll();
            if (!lukituslista.contains(kirjain)) {
                uusiLista.add(kirjain);
            }
        }
        return uusiLista;
    }
    
    /**
     * Lisää merkin lukituslistaan. Lukituslistaa käytetään, mikäli ei haluta kirjaimen vaihtuvan seuraavassa käännöksessä
     * Lukitsemista kannattaa käyttää jos kokee kirjaimen olevan oikein viimeksi palautetussa tekstissä.
     * 
     * @param kirjainStringi lukittava merkki String-muuttujana
     * @return totuusarvo onnistuiko / eikö onnistunut
     */

    public boolean pidaKirjain(String kirjainStringi) {
        Character kirjain = stringiKirjaimeksi(kirjainStringi);
        if (kirjain != null) {
            lukituslista.add(kirjain);
            return true;
        }
        return false;
    }
    
    /**
     * Lisää pakotetun kirjaimenvaihdoksen tietystä kirjaimesta tiettyyn kirjaimeen. Pakotettu kirjainvaihdos lisätään
     * kirjaintenVaihdot-muuttujaan, jota käytetään muissa metodeissa kirjainten varsinaiseen vaihtamiseen. Lisä myös korvattavan
     * kirjaimen lukituslistaan, jolloin sitä ei voida enää vaihtaa.
     * 
     * @param vaihdettavaKirjainStringi mikä kirjain vaihdetaan
     * @param korvaavaKirjainStringi mihin kirjaimeen vaihdetaan
     * @return totuusarvo onnistuiko kirjaimen vaihtaminen
     */

    public boolean vaihdaKirjain(String vaihdettavaKirjainStringi, String korvaavaKirjainStringi) {
        Character vaihdettavaKirjain = stringiKirjaimeksi(vaihdettavaKirjainStringi);
        Character korvaavaKirjain = stringiKirjaimeksi(korvaavaKirjainStringi);
        if (vaihdettavaKirjain != null && korvaavaKirjain != null) {
            kirjaintenVaihdot.put(vaihdettavaKirjain, korvaavaKirjain);
            lukituslista.add(korvaavaKirjain);
            return true;
        }
        return false;
    }
    
    /**
     * Tekee saman asian vaihdaKirjain-metodi, mutta ilman kirjainlukitusta
     * 
     * @param vaihdettavaKirjainStringi mikä kirjain vaihdetaan
     * @param korvaavaKirjainStringi mihin kirjaimeen vaihdetaan
     * @return totuusarvo onnistuiko kirjaimen vaihtaminen
     */

    public boolean vaihdaKirjainIlmanLukitusta(String vaihdettavaKirjainStringi, String korvaavaKirjainStringi) {
        Character vaihdettavaKirjain = stringiKirjaimeksi(vaihdettavaKirjainStringi);
        Character korvaavaKirjain = stringiKirjaimeksi(korvaavaKirjainStringi);
        if (vaihdettavaKirjain != null && korvaavaKirjain != null) {
            kirjaintenVaihdot.put(vaihdettavaKirjain, korvaavaKirjain);
            return true;
        }
        return false;
    }
    
    /**
     * Muuttaa sille annetun stringin kirjaimeksi, mikäli stringin pituus on 1.
     * 
     * @param kirjainStringi kirjain string-muodossa
     * @return kijain Character-muodossa
     */

    protected Character stringiKirjaimeksi(String kirjainStringi) {
        Character kirjain = null;
        if (kirjainStringi.length() == 1) {
            char[] kirjaimet = kirjainStringi.toCharArray();
            kirjain = kirjaimet[0];
        }
        return kirjain;
    }
}
