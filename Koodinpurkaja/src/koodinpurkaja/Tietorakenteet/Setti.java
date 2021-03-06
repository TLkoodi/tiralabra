package koodinpurkaja.Tietorakenteet;
/**
 * Luokalla toteutetaan set-tyyppinen tietorakenne. Tietorakenteen pohjana käytetään Mappi-luokkaa.
 * Esikuvana toiminut TreeSet ja TreeMap luokat, joissa TreeSet on myöskin toteutettu vahvasti TreeMap-luokan avulla.
 * @author Tony
 */

public class Setti<T>{
    
    Mappi mappi = new Mappi();
    
    /**
     * Konstruktori. Oletuksena luokalla on mappi, jota se käyttää tietorakenteenaan.
     */
    
    public Setti() {
    }
    
    /**
     * Lisätään settiin
     * @param tieto settiin lisättävä tieto
     */
    
    public void add(Comparable tieto){
        mappi.put(tieto, null);
    }
    
    /**
     * Setistä poistaminen
     * @param poistettava poistettava tieto
     */
    
    public void remove(Comparable poistettava){
        mappi.remove(poistettava);
    }
    
    /**
     * Etsitään sisältääkö setti haettavan tiedon
     * @param haettava haettava tieto
     * @return totuusarvo kysymykseen "löytyikö?"
     */
    
    public boolean contains(Comparable haettava){
        return mappi.containsKey(haettava);
        
    }
    
    /**
     * Hakee setin arvoista seuraavan mappi-luokan palautaAlinSolmuMahdollisimmanVasemmalta()-metodin perusteella.
     * Tämän jälkeen arvo poistettaan setistä kokonaan ja palautetaan paluuarvona.
     * @return Comparable-olio, joka tuli palautaAlinSolmuMahdollisimmanVasemmalta()-metodin arvoparin getAvain-kyselyllä.
     */
    
    public Comparable poll(){
        Arvopari arvopari = mappi.palautaAlinSolmuMahdollisimmanVasemmalta();
        try{
        if (arvopari.isEmpty()){
            return null;
        }
        Comparable tieto = arvopari.getAvain();
        mappi.remove(arvopari.getAvain());
        return tieto;
        } catch (Exception e){
            return null;
        }
    }

}
