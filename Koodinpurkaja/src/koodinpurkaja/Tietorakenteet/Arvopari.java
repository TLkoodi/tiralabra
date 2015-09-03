
package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class Arvopari<T,E>{
    
    private Comparable avain = null;
    private Comparable arvo = null;
    private Arvopari nextVasen;
    private Arvopari nextOikea;
    
    public Arvopari(Comparable avain, Comparable arvo){
        this.avain = avain;
        this.arvo = arvo;
        nextVasen = null;
        nextOikea = null;
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
    
    public void setNextVasen(Arvopari nextpari){
        this.nextVasen = nextpari;
    }
    
    public void setNextOikea(Arvopari nextOikeaPari){
        this.nextOikea = nextOikeaPari;
    }
    
    public Arvopari getNextVasen(){
        return nextVasen;
    }
    
    public Arvopari getNextOikea(){
        return nextOikea;
}
    
    public boolean isEmpty(){
        if (getAvain() == null){
            return true;
        }
        return false;
    }

}
