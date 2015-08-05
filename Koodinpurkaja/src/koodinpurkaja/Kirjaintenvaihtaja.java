package koodinpurkaja;

import java.util.TreeMap;

/**
 *
 * @author Tony
 */
public class Kirjaintenvaihtaja {

    private String teksti;
    private TreeMap<String,String> korvaukset = new TreeMap<String, String>();
    
    public void setTeksti(String lisattava){
        teksti = lisattava;
    }
    
    public String getTeksti(){
        return teksti;
    }
    
    public void korvaa(String korvattava, String korvaaja){
        if (korvattava.length() == 1 && korvaaja.length() == 1){
            korvaukset.put(korvattava, korvaaja);
        }
    }
    
    public String luePurettuKoodi(){
        String kaannetty = "";
        
        if (korvaukset.isEmpty()){
            return teksti;
        }
        
        for (int i = 0; i < teksti.length(); i++){

            String kirjain = teksti.substring(i, i+1);

            if (korvaukset.containsKey(kirjain)){
                kaannetty += korvaukset.get(kirjain);
            } else {
                kaannetty += kirjain;
            }
        }
        return kaannetty;
    }

}
