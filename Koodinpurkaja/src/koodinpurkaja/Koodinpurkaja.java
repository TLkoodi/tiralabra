
package koodinpurkaja;

/**
 *
 * @author Tony
 */
public class Koodinpurkaja {
    
    static Salakoodi salajuttu;

    public static void main(String[] args) {
       salajuttu = new Salakoodi();
       salajuttu.lisaaTeksti("aaac");
      Analysoija analysoija = new Analysoija();
      analysoija.analysoiFrekvenssi("aaac");
    }
    
}