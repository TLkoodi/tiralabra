
package koodinpurkaja.Tietorakenteet;

/**
 * Arvopari-luokkaa käytetään tietorakenteena sisältämään Avain-arvon ja siihen liitetyn varsinaisen arvon. Luokan
 * pääasiallinen käyttötarkoitus on toimia solmutoteutuksen "mappi"-luokkaan.
 * @author Tony
 */
public class Arvopari<T,E>{
    
    private Comparable avain = null;
    private Comparable arvo = null;
    private Arvopari nextVasen;
    private Arvopari nextOikea;
    
    /**
     * Luokkaa käytetään sisältämään avain ja siihen liittyvä arvo. Lisäksi luokalla voi olla tiedoissaan luokan seuraavat
     * ilmentymät oikealle ja vasemmalle. Näin luokkaa voidaan käyttää puurakenteessa hyväksi.
     * @param avain avainarvo luokalle
     * @param arvo luokan sisältämä arvo
     */
    
    public Arvopari(Comparable avain, Comparable arvo){
        this.avain = avain;
        this.arvo = arvo;
        nextVasen = null;
        nextOikea = null;
    }
    
    /**
     * Getteri
     * @return arvo 
     */
    
    public Comparable getArvo(){
        if (arvo != null){
        return this.arvo;
        }
        return null;
    }
    
    /**
     * Getteri
     * @return avain 
     */
    
    public Comparable getAvain(){
        if (avain != null){
        return this.avain;
        }
        return null;
    }
    
    /**
     * Setteri
     * @param arvo 
     */
    
    public void setArvo(Comparable arvo){
        this.arvo = arvo;
    }
    
    /**
     * Setteri
     * @param avain 
     */
    
    public void setAvain(Comparable avain){
        this.avain = avain;
    }
    
    /**
     * Tällä asetetaan luokalle luokan "vasemmalla puolella" oleva seuraava ilmentymä.
     * @param nextpari 
     */
    
    public void setNextVasen(Arvopari nextpari){
        this.nextVasen = nextpari;
    }
    
    /**
     * Tällä asetetaan luokalle luokan "oikealla puolella" oleva seuraava ilmentymä.
     * @param nextpari 
     */
    
    public void setNextOikea(Arvopari nextOikeaPari){
        this.nextOikea = nextOikeaPari;
    }
    
    /**
     * Getteri
     * @return  
     */
    
    public Arvopari getNextVasen(){
        return nextVasen;
    }
    
    /**
     * Getteri
     * @return 
     */
    
    public Arvopari getNextOikea(){
        return nextOikea;
}
    
    /**
     * Tarkistetaan onko luokka "tyhjä", tarkastamalla onko sillä avainta.
     * @return 
     */
    
    public boolean isEmpty(){
        if (getAvain() == null){
            return true;
        }
        return false;
    }

}
