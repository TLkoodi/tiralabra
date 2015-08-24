package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class PriorisoituJono {

    private LinkitettyLista lista;

    public PriorisoituJono() {
        lista = new LinkitettyLista();
    }

    public void add(Comparable tieto) {
        if (lista.isEmpty()) {
            lista.add(tieto);
        } else {

            LinkitettyLista uusiLista = new LinkitettyLista();
            boolean loytyikoOikeaKohta = false;

            while (!lista.isEmpty() && !loytyikoOikeaKohta) {
                Comparable verrattavaTieto = (Comparable) lista.poll();
                int vertailu = tieto.compareTo(verrattavaTieto);

                if (vertailu > 0) {
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

    public Object poll() {
        return lista.poll();
    }

    public Object peek() {
        return lista.peek();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

}
