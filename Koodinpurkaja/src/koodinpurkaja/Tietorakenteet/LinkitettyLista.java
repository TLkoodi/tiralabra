package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class LinkitettyLista implements Cloneable{

    private Solmu aloitusSolmu;

    public LinkitettyLista() {
        aloitusSolmu = null;

    }

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

    public Object poll() {
        if (aloitusSolmu == null) {
            return null;
        }
        Object tieto = aloitusSolmu.getTieto();
        aloitusSolmu = aloitusSolmu.getNextSolmu();
        return tieto;
    }

    public Object peek() {
        if (aloitusSolmu == null) {
            return null;
        }
        return aloitusSolmu.getTieto();
    }

    public boolean isEmpty() {
        if (aloitusSolmu == null) {
            return true;
        }
        return false;
    }

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
    
    @Override
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
