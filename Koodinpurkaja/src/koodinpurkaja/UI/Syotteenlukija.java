
package koodinpurkaja.UI;

/**
 * Ohjelman hallintaliittymän toteutus.
 * @author Tony
 */
import java.util.Scanner;
import koodinpurkaja.KoodinKaantaja;
import koodinpurkaja.Tiedostonlukija;

public class Syotteenlukija {

    private static Scanner lukija = new Scanner(System.in);
    private static KoodinKaantaja kaantaja = new KoodinKaantaja();
    private static Tiedostonlukija tiedostonLukija = new Tiedostonlukija();

    /**
     * Luokka joka ylläpitää ohjelman käyttöliittymää ja neuvoo käyttäjää komennoissa.
     */
    
    public void run() {
        System.out.println("Tervetuloa purkamaan koodia, aloitetaanko? (K/E):");
        String luettu = lukija.nextLine();
        while (!"E".equals(luettu) && !"K".equals(luettu)) {
            System.out.println("Virheellinen syöte, aloitetaanko? (K/E):");
            luettu = lukija.nextLine();
        }
        if ("E".equals(luettu)) {
            return;
        }

        kaanna();
        while (!"L".equals(luettu)) {
            System.out.println("Käytettävissä olevat operaatiot:");
            System.out.println("Käännä uudelleen = K, Pidä kirjain = P, Vaihda kirjain = V, Lopeta = L");
            luettu = lukija.nextLine();
            if (!"K".equals(luettu) && !"P".equals(luettu) && !"V".equals(luettu) && !"L".equals(luettu)) {
                System.out.println("Virheellinen syöte");
            } else if ("K".equals(luettu)){
                kaanna();
            } else if ("P".equals(luettu)) {
                pida();
            } else if ("V".equals(luettu)){
                vaihda();
            }
        }
        return;
    }
    
    /**
     * Käyttöliittymän metodi, joka kääntää aiemmin käsittelyssä olleen tekstin kaantaja-luokassa. Luo uuden tekstin tekstitiedostosta
     * mikäli kaantaja-luokkaan ei vielä tekstiä ole asetettu.
     * 
     * Tulostaa käännetyn tekstin.
     */
    
    public void kaanna() {
        if (kaantaja.getKaannettava() == null){
        kaantaja.setKaannettava(tiedostonLukija.lueTiedosto("purettavaTeksti.txt"));
        }
        String kaannos = kaantaja.kaanna();
        System.out.println("Purettu teksti:");
        System.out.println(kaannos);
    }
    
    /**
     * Antaa kaantaja-luokalle käskyn lukita kirjain.
     */
    
    public void pida(){
        System.out.println("Anna lukittava kirjain:");
        String lukittava = lukija.nextLine();
        boolean onnistuiko = kaantaja.pidaKirjain(lukittava);
        if (onnistuiko != true){
            System.out.println("Lukitus ei onnistunut, tarkista syöte");
        }
        
    }
    
    /**
     * Antaa kaantaja-luokalle komennon vaihtaa kirjain toiseen tiettyyn kirjaimeen
     */
    
    public void vaihda(){
        System.out.println("Anna vaihdettava kirjain:");
        String vaihdettava = lukija.nextLine();
        System.out.println("Anna korvaava kirjain:");
        String korvaaja = lukija.nextLine();
        boolean onnistuiko = kaantaja.vaihdaKirjainManuaalisesti(vaihdettava, korvaaja);
        if (onnistuiko != true){
            System.out.println("Vaihto ei onnistunut, tarkista syöte");
        }
    }

}
