package koodinpurkaja.Tietorakenteet;

/**
 * Korva tietorakenteen "PriorityQueue"
 * @author Tony
 */
public class PriorisoituJono<T> {

    private LinkitettyLista lista;

    /**
     * Konstruktori. Apuna käytetään LinkitettyLista-luokkaa
     */
    
    public PriorisoituJono() {
        lista = new LinkitettyLista();
    }
    
    /**
     * Lisätään LinkitettyynListaan haluttu tieto. Koska nyt kuitenkin toteutetaan priortisoitu jono, niin tehdään vertailua
     * Linkitetyn listan arvojen suhteen ja lisätään tieto sille kuuluvaan paikkan jonossa, eikä jonon perään.
     * @param tieto lisättävä tieto 
     */

    public void add(Comparable tieto) {
        if (lista.isEmpty()) {
            lista.add(tieto);
        } else {

            LinkitettyLista uusiLista = new LinkitettyLista();
            boolean loytyikoOikeaKohta = false;

            while (!lista.isEmpty() && !loytyikoOikeaKohta) {
                Comparable verrattavaTieto = (Comparable) lista.poll();
                int vertailu = tieto.compareTo(verrattavaTieto);

                if (vertailu < 0) {
                    uusiLista.add(tieto);
                    uusiLista.add(verrattavaTieto);
                    loytyikoOikeaKohta = true;
                } else {
                    uusiLista.add(verrattavaTieto);
                }
            }

            if (!loytyikoOikeaKohta) {
                uusiLista.add(tieto);

            }

            while (!lista.isEmpty()) {
                uusiLista.add(lista.poll());
            }

            lista = uusiLista;
        }
    }
    
    /**
     * Poistetaan jono ensimmäinen ja haetaan sen arvo
     * @return 
     */

    public T poll() {
        return (T)lista.poll();
    }
    
    /**
     * Haetaan jonon ensimmäinen arvo, muttei poisteta sitä jonosta
     * @return 
     */

    public T peek() {
        return (T)lista.peek();
    }
    
    /**
     * Tarkistetaan onko jono tyhjä.
     * @return 
     */

    public boolean isEmpty() {
        return lista.isEmpty();
    }

}
