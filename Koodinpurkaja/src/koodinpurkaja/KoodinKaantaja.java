
package koodinpurkaja;

import java.util.PriorityQueue;

public class KoodinKaantaja {
    Frekvenssitiedot sanakirja = new Frekvenssitiedot();
    PriorityQueue yleisyystiedot = new PriorityQueue();
    
    public void kaanna(){
       yleisyystiedot = sanakirja.haeEnglanti();
    }
}
