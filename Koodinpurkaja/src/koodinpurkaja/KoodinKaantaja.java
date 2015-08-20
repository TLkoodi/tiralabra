package koodinpurkaja;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import koodinpurkaja.Tietorakenteet.LinkitettyLista;

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

        //LinkedList<Character> yleisyystiedot = new LinkedList<Character>();
        LinkitettyLista yleisyystiedot = sanakirja.haeEnglanti();
        
        yleisyystiedot = (LinkitettyLista)poistaListaltaLukitutKirjaimet(yleisyystiedot);
        
        PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = analysoija.analysoiFrekvenssi(kaannettava);
        
        Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();
        
        kirjaintenvaihtaja.setTeksti(kaannettava);

        kirjaintenvaihtaja = vaihdaKayttajanVaihtamatKirjaimet(kirjaintenvaihtaja, yleisyystiedot);
        
        String valikaannos = kirjaintenvaihtaja.luePurettuKoodi();
        
        kirjaintenvaihtaja.setTeksti(valikaannos);
        
        kirjaintenvaihtaja = korvaaTekstinYleisimmatKirjaimet(yleisyystiedot, kirjaintenvaihtaja, tekstinKirjaintiedot);

        
        kaannettava = kirjaintenvaihtaja.luePurettuKoodi();
        kirjaintenVaihdot.clear();
        return kaannettava;
    }
    
    protected Kirjaintenvaihtaja vaihdaKayttajanVaihtamatKirjaimet(Kirjaintenvaihtaja kirjaintenvaihtaja, LinkitettyLista yleisyystiedot){
        LinkitettyLista yleisyystiedotKlooni = (LinkitettyLista)yleisyystiedot.clone();
        
        final Set<Map.Entry<Character, Character>> kirjainVaihdot = kirjaintenVaihdot.entrySet();
        
        for (Map.Entry<Character, Character> korvaus : kirjainVaihdot) {
            if (kelpuutetutKirjaimet.contains(korvaus.getValue().toString())) {
//                while (kirjaintenVaihdot.entrySet().contains((Character)yleisyystiedotKlooni.peek())){
//                    yleisyystiedotKlooni.poll();
//                }
                kirjaintenvaihtaja.korvaa(korvaus.getValue(), (Character)yleisyystiedotKlooni.poll());
      //          kirjaintenvaihtaja.korvaa(korvaus.getKey(), korvaus.getValue());
            }
        }
        return kirjaintenvaihtaja;
    }
    
    /**
     * Jos lukituslistalla tai kirjaintenvaihtotiedoista löytyy yleisyystietojen seuraava tarjottu kirjain, 
     * se hylätään ja otetaan seuraava, ja aloitetaan looppi alusta
     * 
     * Jos lukitulistala löytyy korvattava kirjain, otetaan seuraava korvattava kirjain käsittelyyn ja aloitetaan looppi alusta
     * 
     * Jos kirjaintenvaihdoista löytyy korvattava kirjaimena käsiteltävä kijrain, se korvataan sille asetetulla korvaavuudella.
     * Ja aloitetaan looppi alusta.
     * 
     * Jos korvattava kirjain löytyy "kelpuutetutKirjaimet"-stringistä, se korvataan yleisyystiedot-listan jonon ensimmäisellä,
     * eli yleisimällä kirjaimella. Looppi alotetaan tämän jälkeen alusta.
     * 
     * Jos korvattava kirjain ei löydy "kelpuutetutKirjaimet"-stringistä, otetaan seuraava kirjain käsittelyyt ja aloitetaan
     * looppi alusta.
     * 
     * @param yleisyystiedot Kielen (esim. englanti) kirjaimet yleisyysjärjestyksessä.
     * @param kirjaintenvaihtaja Luokka joka hoitaa varsinaisen kirjainten vaihdon sille annettujen ohjeiden perusteella
     * @param tekstinKirjaintiedot Tekstin merkit yleisyysjärjestyksessä.
     * @return Kirjaintenvaihtaja, jotta voidaan jatkaa sille komentojen antamista.
     */
    
    protected Kirjaintenvaihtaja korvaaTekstinYleisimmatKirjaimet(LinkitettyLista yleisyystiedot, Kirjaintenvaihtaja kirjaintenvaihtaja, PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot){
        while (!yleisyystiedot.isEmpty() && !tekstinKirjaintiedot.isEmpty()) {
            Character korvattava = tekstinKirjaintiedot.peek().getKoodi();
            Character korvaaja = (Character)yleisyystiedot.peek();

            if (lukituslista.contains(korvaaja) || kirjaintenVaihdot.containsValue(korvaaja)) {
                yleisyystiedot.poll();

            } else if (lukituslista.contains(korvattava)) {
                tekstinKirjaintiedot.poll();

            } else if (kirjaintenVaihdot.containsKey(korvattava)) {
                kirjaintenvaihtaja.korvaa(korvattava, kirjaintenVaihdot.get(korvattava));
                tekstinKirjaintiedot.poll();

            } else if (kelpuutetutKirjaimet.contains(korvattava.toString())) {
                kirjaintenvaihtaja.korvaa(korvattava, (Character)yleisyystiedot.poll());
                tekstinKirjaintiedot.poll();

            } else {
                tekstinKirjaintiedot.poll();
            }
        }
        return kirjaintenvaihtaja;
    }
    
    /**
     * Metodi poistaa sille annetusta linkitetystä listasta kaikki ne merkit, mitkä on lisätty lukituslista-muuttujaan.
     * Tämän jälkeen lista palautetaan takaisin.
     * 
     * @param lista muokattava lista
     * @return lista josta on poiistettu lukituslista-muuttujan merkit
     */

    public LinkitettyLista poistaListaltaLukitutKirjaimet(LinkitettyLista lista) {
    //    LinkedList<Character> uusiLista = new LinkedList<Character>();
        LinkitettyLista uusiLista = new LinkitettyLista();
        while (!lista.isEmpty()) {
            Character kirjain = (Character)lista.poll();
            if (!lukituslista.contains(kirjain)) {
                uusiLista.add((Character)kirjain);
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

    public boolean vaihdaKirjainManuaalisesti(String vaihdettavaKirjainStringi, String korvaavaKirjainStringi) {
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
        if (kirjainStringi == null){
            return null;
        }
        
        Character kirjain = null;
        
        if (kirjainStringi.length() == 1) {
            char[] kirjaimet = kirjainStringi.toCharArray();
            kirjain = kirjaimet[0];
        }
        return kirjain;
    }
}
