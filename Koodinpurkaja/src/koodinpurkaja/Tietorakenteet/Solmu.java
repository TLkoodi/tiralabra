package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class Solmu {

    private Object tieto;
    private Solmu nextSolmu = null;
    private Solmu previousSolmu = null;

    public Solmu(Object asetettavaTieto) {
        tieto = asetettavaTieto;
    }

    public void setNextSolmu(Solmu seuraavaSolmu) {
        nextSolmu = seuraavaSolmu;
    }

    public void setPreviousSolmu(Solmu edellinenSolmu) {
        previousSolmu = edellinenSolmu;
    }

    public Solmu getNextSolmu() {
        return nextSolmu;
    }

    public Solmu getPreviousSolmu() {
        return previousSolmu;
    }
    
    public Object getTieto(){
        return tieto;
    }

}
