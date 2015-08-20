package koodinpurkaja;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * @author Tony
 */
public class Analysoija {

    /**
     * Luokka luo priorisoidun jonon, jonne luo frekvenssiolioita laskeKirjaimet-metodin laskujen perusteella.
     * 
     * @param teksti Teksti, joka halutaan analysoitavan kunkin merkin perusteella.
     * @return Priorisoitu jono, jonka sisältönä on Frekvenssiolio (jossa on tieto merkistä ja sen lukumäärästä).
     */
    public PriorityQueue<Frekvenssiolio> analysoiFrekvenssi(String teksti) {
         
        PriorityQueue<Frekvenssiolio> frekvenssit = new PriorityQueue<Frekvenssiolio>();
        
        TreeMap<Character, Frekvenssiolio> kirjaimet = new TreeMap<Character, Frekvenssiolio>();
        kirjaimet = laskeKirjaimet(teksti);
        for (char c : kirjaimet.keySet()){
            Frekvenssiolio olio = kirjaimet.get(c);
            frekvenssit.add(olio);
        }
        
        return frekvenssit;
    }
    
    /**
    *Metodi laskee sille syötteenä annetusta Stringistä eri merkit.
    *Merkki lisätään frekvenssiolioon, jonka arvoa kasvatetaan joka kerta kun merkki ilmaantuu uudelleen.
    *Frekvenssiolio lisätään HashMappiin, jonka avaimena toimii kyseinen merkki. 
    * Tällöin frekvenssiolio voidaan kätevästi hakea merkin perusteella.
    * 
     * @param teksti
     * @return 
    */
    
    public TreeMap<Character, Frekvenssiolio> laskeKirjaimet(String teksti){
        TreeMap<Character, Frekvenssiolio> kirjaimet = new TreeMap<Character, Frekvenssiolio>();
        
        for (int i = 0; teksti.length() > i; i++) {
        char[] merkkitaulukko = null;
        merkkitaulukko = teksti.toCharArray();
            if (!kirjaimet.containsKey(merkkitaulukko[i])) {
                Frekvenssiolio olio = new Frekvenssiolio(merkkitaulukko[i]);
                olio.kasvata();
                kirjaimet.put(merkkitaulukko[i], olio);
            
            } else {
               kirjaimet.get(merkkitaulukko[i]).kasvata();
            }
            
        }
        
        return kirjaimet;
    }

}
