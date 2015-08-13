package koodinpurkaja;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Tony
 */
public class Tiedostonlukija {
    
    /**
     * Lukee sille parametrina annetun tiedostonimen perusteella tiedoston, ja palauttaa sen sisällön Stringinä.
     * 
     * @param tiedostonNimi tiedoston nimi, jonka perusteella metodi hakee tiedoston
     * @return tiedoston sisältö String-muodossa
     */

    public String lueTiedosto(String tiedostonNimi) {
        BufferedReader lukija;
        try {
            FileInputStream fstream = new FileInputStream(tiedostonNimi);
            DataInputStream in = new DataInputStream(fstream);
            lukija = new BufferedReader(new InputStreamReader(in));

            String rivi;
            String teksti = "";

            while ((rivi = lukija.readLine()) != null) {
                teksti += rivi;
            }
            in.close();
            return teksti;
        } catch (IOException ex) {
            System.out.println("Jokin meni vikaan");
            return null;
        }
    }

}
