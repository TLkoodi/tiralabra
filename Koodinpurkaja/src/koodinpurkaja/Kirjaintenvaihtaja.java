package koodinpurkaja;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Tony
 */
public class Kirjaintenvaihtaja {

    private String teksti;
    private TreeMap<Character, Character> korvaukset = new TreeMap<Character, Character>();
    private TreeMap<Character, Character> korvauksetTakaperin = new TreeMap<Character, Character>();   

    /**
     * Setteri, tällä lisätään teksti joka halutaan kääntää
     *
     * @param lisattava Käännettävä teksti
     */
    public void setTeksti(String lisattava) {
        teksti = lisattava;
    }

    /**
     * Palauttaa käännettävän tekstin kääntämättömänä.
     *
     * @return luokkaan lisätty käännettävä teksti kääntämättömänä
     */
    public String getTeksti() {
        return teksti;
    }

    /**
     * Lisää korvaukset-muutujaan tiedon mikä kirjain halutaan korvata millä
     * kirjaimella.
     *
     * @param korvattava korvattava kirjain
     * @param korvaaja korvaava kirjain
     */
    public void korvaa(Character korvattava, Character korvaaja) {
            korvaukset.put(korvattava, korvaaja);
            korvauksetTakaperin.put(korvaaja, korvattava);
        }
    
    /**
     * Käy kirjaimet yksitellen läpi ja hakee jokaisen kohdalla tiedon siitä, millä kirjaimella
     * kirjain korvatan. Tämän jälkeen kirjain lisätään tulostettavaan
     * Stringiin.
     *
     * @return Kirjainkorvausten perusteella käännetty teksti
     */
    
    public String luePurettuKoodi() {
        String kaannetty = "";

        if (korvaukset.isEmpty()) {
            return teksti;
        }

        for (int i = 0; i < teksti.length(); i++) {

            Character kirjain = teksti.charAt(i);

            if (korvaukset.containsKey(kirjain)) {
                kaannetty += korvaukset.get(kirjain);
            } else {
                kaannetty += kirjain;
            }
        }
        return kaannetty;
    }

}
