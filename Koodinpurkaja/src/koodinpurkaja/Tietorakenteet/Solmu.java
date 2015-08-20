package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class Solmu {

    private Object tieto;
    private Solmu nextSolmu = null;
    private Solmu previousSolmu = null;
    
    /**
     * Konstruktori
     * @param asetettavaTieto solmun sisältämä tieto
     */

    public Solmu(Object asetettavaTieto) {
        tieto = asetettavaTieto;
    }

    /**
     * Antaa solmulle tiedot seuraavasta solmusta
     * @param seuraavaSolmu seuraavaksi solmuksi merkittävä solmu
     */
    
    public void setNextSolmu(Solmu seuraavaSolmu) {
        nextSolmu = seuraavaSolmu;
    }
    
    /**
     * Antaa solmulle tiedot edellisestä solmusta
     * @param edellinenSolmu edelliseksi solmuksi merkittävä solmu
     */

    public void setPreviousSolmu(Solmu edellinenSolmu) {
        previousSolmu = edellinenSolmu;
    }
    
    /**
     * Kertoo mikä on seuraava solmu
     * @return seuraava solmu
     */

    public Solmu getNextSolmu() {
        return nextSolmu;
    }
    
    /**
     * Kertoo mikä on edellinen solmu
     * @return edellinen solmu
     */

    public Solmu getPreviousSolmu() {
        return previousSolmu;
    }
    
    /**
     * Palauttaa solmun sisältämän tiedot object-muodossa
     * @return solmun tieto object-muodossa
     */
    
    public Object getTieto(){
        return tieto;
    }

}
