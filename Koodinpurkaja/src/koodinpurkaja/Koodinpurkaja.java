
package koodinpurkaja;

import koodinpurkaja.UI.Syotteenlukija;
/**
 *
 * @author Tony
 */
public class Koodinpurkaja {

    /**
     * Pääluokka ja metodi jonka kautta sovellus käynnistetään.
     * 
     */
    public static void main(String[] args) {
        Syotteenlukija kayttoliittyma = new Syotteenlukija();
        kayttoliittyma.run();
    }
    
}