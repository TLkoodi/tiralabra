package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class LinkitettyLista {

    private Solmu aloitusSolmu;

    /**
     * Konstruktori
     */
    
    public LinkitettyLista() {
        aloitusSolmu = null;

    }
    
    /**
     * Lisätään listan viimeisen solmun perään uusi solmu. Jos aloitussolmua ei ole, luodaan ensimmäinen solmu.
     * 
     * Aikavaativuus O(n)
     * 
     * @param tieto luotavaan solmuun lisättävä tieto 
     */

    public void add(Object tieto) {
        if (aloitusSolmu != null) {

            Solmu solmukohta = aloitusSolmu;

            while (solmukohta.getNextSolmu() != null) {
                solmukohta = solmukohta.getNextSolmu();
            }
            Solmu edellinenSolmu = solmukohta;
            Solmu luotavaSolmu = new Solmu(tieto);
            solmukohta.setNextSolmu(luotavaSolmu);
            luotavaSolmu.setPreviousSolmu(edellinenSolmu);
        } else {
            aloitusSolmu = new Solmu(tieto);
        }
    }
    
    /**
     * Haetaan listan ensimmäinsen solmun sisältö ja palautetaan se. Poistetaan ensimmäinen solmu, ja seuraava listassa
     * ottaa ensimmäisen paikan.
     * 
     * @return ensimmäisessä solmuss ollut tieto palautetaan Object-muodossa
     */

    public Object poll() {
        if (aloitusSolmu == null) {
            return null;
        }
        Object tieto = aloitusSolmu.getTieto();
        aloitusSolmu = aloitusSolmu.getNextSolmu();
        return tieto;
    }
    
    /**
     * Haetaan listan ensimmäisen solmun sisältämä tieto object-muodossa
     * @return ensimmäisen solmun sisältämä tieto object-muodossa
     */

    public Object peek() {
        if (aloitusSolmu == null) {
            return null;
        }
        return aloitusSolmu.getTieto();
    }

    /**
     * Kertoo onko LinkitettyLista tyhje, eli onko sillä solmuja.
     * @return totuusarvo true / false
     */
    
    public boolean isEmpty() {
        if (aloitusSolmu == null) {
            return true;
        }
        return false;
    }

    /**
     * Käydään solmut läpi ja tarkistetaan onko haettava tieto missään solmuista
     * @param tieto Haettava solmu
     * 
     * O(n) aikainen
     * 
     * @return totuusarvo true / false
     */
    
    public boolean contains(Object tieto) {
        if (aloitusSolmu == null) {
            return false;
        }

        Solmu kasittelySolmu = aloitusSolmu;
        while (kasittelySolmu.getNextSolmu() != null) {
            if (kasittelySolmu.getTieto().equals(tieto)) {
                return true;
            }
            kasittelySolmu = kasittelySolmu.getNextSolmu();
        }
        return false;
    }

    /**
     * Luo kloonin listasta
     * @return listan klooni
     */
    
    public LinkitettyLista clone(){
        LinkitettyLista kopio = new LinkitettyLista();
        if (aloitusSolmu == null) {
            return kopio;
        }
        
        Solmu kasittelySolmu = aloitusSolmu;
        while (kasittelySolmu != null) {
            Object tieto = new Object();
            tieto = kasittelySolmu.getTieto();
            kopio.add(tieto);
            kasittelySolmu = kasittelySolmu.getNextSolmu();
        }
        return kopio;
    }
    

}
