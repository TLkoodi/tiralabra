package koodinpurkaja;

import java.util.TreeMap;

/**
 *
 * @author Tony
 */
public class Kirjaintenvaihtaja {

    private String teksti;
    private TreeMap<String,String> korvaukset = new TreeMap<String, String>();
    
    /**
     * Setteri, tällä lisätään teksti joka halutaan kääntää
     * @param lisattava Käännettävä teksti
     */
    public void setTeksti(String lisattava){
        teksti = lisattava;
    }
    
    /**
     * Palauttaa käännettävän tekstin kääntämättömänä.
     * @return luokkaan lisätty käännettävä teksti kääntämättömänä
     */
    public String getTeksti(){
        return teksti;
    }
    
    /**
     * Lisää korvaukset-muutujaan tiedon mikä kirjain halutaan korvata millä kirjaimella.
     * @param korvattava korvattava kirjain
     * @param korvaaja korvaava kirjain
     */
    public void korvaa(String korvattava, String korvaaja){
        if (korvattava.length() == 1 && korvaaja.length() == 1){
            korvaukset.put(korvattava, korvaaja);
        }
    }
    
    /**
     * Käy kirjaimet yksitellen läpi ja hakee tiedon siitä, millä kirjaimella kirjain korvatan. Tämän jälkeen kirjain lisätään
     * tulostettavaan Stringiin.
     * @return Kirjainkorvausten perusteella käännetty teksti
     */
    public String luePurettuKoodi(){
        String kaannetty = "";
        
        if (korvaukset.isEmpty()){
            return teksti;
        }
        
        for (int i = 0; i < teksti.length(); i++){

            String kirjain = teksti.substring(i, i+1);

            if (korvaukset.containsKey(kirjain)){
                kaannetty += korvaukset.get(kirjain);
            } else {
                kaannetty += kirjain;
            }
        }
        return kaannetty;
    }

}
