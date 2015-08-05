
package koodinpurkaja;

/**
 *
 * @author Tony
 */
public class Frekvenssiolio implements Comparable<Frekvenssiolio>{

    private char koodi;
    private int maara;
    
    public Frekvenssiolio(char koodi) {
        this.koodi = koodi;
        this.maara = 0;
    }
    
    public char getKoodi(){
        return koodi;
    }
    
    public void kasvata(){
        maara++;
    }
    
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
