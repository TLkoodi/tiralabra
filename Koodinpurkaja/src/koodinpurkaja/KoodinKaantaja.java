
package koodinpurkaja;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KoodinKaantaja {
    private Frekvenssitiedot sanakirja = new Frekvenssitiedot();
    private LinkedList yleisyystiedot = new LinkedList();
    private String kelpuutetutKirjaimet = "abcdefghijklmnopqrstuvwxyzåäö";
    
    public String kaanna(String teksti){
       yleisyystiedot = sanakirja.haeEnglanti();
       
       Analysoija analysoija = new Analysoija();
       
       PriorityQueue<Frekvenssiolio> tekstinKirjaintiedot = analysoija.analysoiFrekvenssi(teksti);
       
       Kirjaintenvaihtaja kirjaintenvaihtaja = new Kirjaintenvaihtaja();
       
       kirjaintenvaihtaja.setTeksti(teksti);
       
       while (!yleisyystiedot.isEmpty() && !tekstinKirjaintiedot.isEmpty()){
       //    System.out.println("Korvataan: " + tekstinKirjaintiedot.peek().getKoodi() + " kirjaimella " + yleisyystiedot.peek());
           if (kelpuutetutKirjaimet.contains(tekstinKirjaintiedot.peek().getKoodi().toString())){
           kirjaintenvaihtaja.korvaa(tekstinKirjaintiedot.poll().getKoodi().toString(), yleisyystiedot.poll().toString());
           } else {
               tekstinKirjaintiedot.poll();
           }
       }
       
       return kirjaintenvaihtaja.luePurettuKoodi();
    }
}
