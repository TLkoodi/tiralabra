package koodinpurkaja;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Analysoija {

    public PriorityQueue<Frekvenssiolio> analysoiFrekvenssi(String teksti) {
         
        PriorityQueue<Frekvenssiolio> frekvenssit = new PriorityQueue<Frekvenssiolio>();
        
        HashMap<Character, Frekvenssiolio> kirjaimet = new HashMap<Character, Frekvenssiolio>();
        kirjaimet = laskeKirjaimet(teksti);
        for (char c : kirjaimet.keySet()){
            Frekvenssiolio olio = kirjaimet.get(c);
            frekvenssit.add(olio);
        }
        System.out.println(frekvenssit.poll().getKoodi());
        
        return frekvenssit;
    }
    
    public static void main(String[] args) {
        Analysoija analyysi = new Analysoija();
        analyysi.analysoiFrekvenssi("kissaPPPPPP-----------");
        
    }
    
    /**
    *Metodi laskee sille syötteenä annetusta Stringistä eri merkit.
    *Merkki lisätään frekvenssiolioon, jonka arvoa kasvatetaan joka kerta kun merkki ilmaantuu uudelleen.
    *Frekvenssiolio lisätään HashMappiin, jonka avaimena toimii kyseinen merkki. 
    * Tällöin frekvenssiolio voidaan kätevästi hakea merkin perusteella.
    * 
    */
    
    public HashMap<Character, Frekvenssiolio> laskeKirjaimet(String teksti){
        HashMap<Character, Frekvenssiolio> kirjaimet = new HashMap<Character, Frekvenssiolio>();
        
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
