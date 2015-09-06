package koodinpurkaja;

import koodinpurkaja.Tietorakenteet.Frekvenssiolio;
import java.util.TreeMap;
import koodinpurkaja.Tietorakenteet.Mappi;
import koodinpurkaja.Tietorakenteet.PriorisoituJono;
import koodinpurkaja.Tietorakenteet.Setti;

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
 public PriorisoituJono<Frekvenssiolio> analysoiFrekvenssi(String teksti){
     PriorisoituJono<Frekvenssiolio> frekvenssit = new PriorisoituJono<Frekvenssiolio>();
       // TreeMap<Character, Frekvenssiolio> kirjaimet = new TreeMap<Character, Frekvenssiolio>();
     Mappi<Character, Frekvenssiolio> kirjaimet = new Mappi<Character, Frekvenssiolio>();
        kirjaimet = laskeKirjaimet(teksti);
//        for (char c : kirjaimet.keySet()){
//            Frekvenssiolio olio = kirjaimet.get(c);
//            frekvenssit.add(olio);
//        }
        Setti keySetti = kirjaimet.keySet();
        boolean onkoNull = false;
        while (!onkoNull){
            Character c = (Character)keySetti.poll();
            if (c != null){
            Frekvenssiolio olio = (Frekvenssiolio)kirjaimet.get(c);
            frekvenssit.add(olio);
            } else {
                onkoNull = true;
            }
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
    
    public Mappi<Character, Frekvenssiolio> laskeKirjaimet(String teksti){
        //TreeMap<Character, Frekvenssiolio> kirjaimet = new TreeMap<Character, Frekvenssiolio>();
        Mappi<Character, Frekvenssiolio> kirjaimet = new Mappi<Character, Frekvenssiolio>();
        
        for (int i = 0; teksti.length() > i; i++) {
        char[] merkkitaulukko = null;
        merkkitaulukko = teksti.toCharArray();
            if (!kirjaimet.containsKey(merkkitaulukko[i])) {
                Frekvenssiolio olio = new Frekvenssiolio(merkkitaulukko[i]);
                olio.kasvata();
                kirjaimet.put(merkkitaulukko[i], olio);
            
            } else {
               Frekvenssiolio maara = (Frekvenssiolio) kirjaimet.get(merkkitaulukko[i]);
               maara.kasvata();
               kirjaimet.put(merkkitaulukko[i], maara);
            }
            
        }
        
        return kirjaimet;
    }

}
