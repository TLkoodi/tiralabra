package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class Setti {

    public Arvopari aloitussolmu = null;
    Mappi mappi = new Mappi();
    
    public Setti() {
    }
    
    public void add(Comparable tieto){
        mappi.put(tieto, null);
    }
    
    public void remove(Comparable poistettava){
        mappi.remove(poistettava);
    }
    
    public boolean contains(Comparable haettavah){
        return mappi.containsKey(haettavah);
        
    }

}
