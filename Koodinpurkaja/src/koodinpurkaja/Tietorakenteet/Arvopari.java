
package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class Arvopari<T> {
    
    private Comparable avain;
    private Comparable arvo;
    
    public Arvopari(Comparable avain, Comparable arvo){
        this.avain = avain;
        this.arvo = arvo;       
    }
    
    public Comparable getArvo(){
        return this.arvo;
    }
    
    public Comparable getAvain(){
        return this.avain;
    }
    
    public void setArvo(Comparable arvo){
        this.arvo = arvo;
    }
    
    public void setAvain(Comparable avain){
        this.avain = avain;
    }
    
}
