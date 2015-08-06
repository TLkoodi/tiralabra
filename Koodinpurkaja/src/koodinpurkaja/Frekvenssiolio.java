
package koodinpurkaja;

/**
 *
 * @author Tony
 */
public class Frekvenssiolio implements Comparable<Frekvenssiolio>{

    private Character koodi;
    private int maara;
    
    /**
     * Konstruktori, joka vaatii syötteenä olion yksilöivän merkin. Koodi alustetaan luvulla 0.
     * 
     * @param koodi Merkki, jonka lukumäärä halutaan oliossa tallentaa
     */
    public Frekvenssiolio(char koodi) {
        this.koodi = koodi;
        this.maara = 0;
    }
    
    /**
     * Getteri merkille.
     * @return Merkki
     */
    public Character getKoodi(){
        return koodi;
    }
    
    /**
     * Kasvatetaan olion lukua. (Esim. jos halutan laskea, että merkki esiintyy taas tekstissä).
     */
    public void kasvata(){
        maara++;
    }
    
    /**
     *
     * @return Paluuarvona luku joka on talletettuna olioon
     */
    public int getMaara(){
        return maara;
    }
    

    @Override
    public int compareTo(Frekvenssiolio o) {
      if (this.maara < o.getMaara()){
          return 1;
      } else if (this.maara == o.maara){
          return 0;
      } else {
          return -1;
      }
    }
    
}
