package koodinpurkaja.Tietorakenteet;

/**
 *
 * @author Tony
 */
public class Mappi<T, E> {

    private Arvopari<Comparable, Comparable> juuri = null;

    public Mappi() {
    }

    public void put(Comparable avain, Comparable arvo) {
        Arvopari<Comparable, Comparable> pari = new Arvopari(avain, arvo);
        putValmisArvopariMappiin(pari);
    }

    public void putValmisArvopariMappiin(Arvopari pari) {
        if (pari == null) {
            return;
        }

        if (juuri == null) {
            juuri = pari;

        } else {
            Arvopari<Comparable, Comparable> kasiteltava = juuri;
            boolean loytyiOikeaPaikka = false;

            while (loytyiOikeaPaikka == false) {
                int isompiko = kasiteltava.getAvain().compareTo(pari.getAvain());

                if (isompiko < 0) {
                    if (kasiteltava.getNextVasen() == null) {
                        kasiteltava.setNextVasen(pari);
                        loytyiOikeaPaikka = true;
                    } else {
                        kasiteltava = kasiteltava.getNextVasen();
                    }

                } else if (isompiko == 0) {
                    kasiteltava.setArvo(pari.getArvo());
                    return;
                } else {

                    if (kasiteltava.getNextOikea() == null) {
                        kasiteltava.setNextOikea(pari);
                        loytyiOikeaPaikka = true;
                    } else {
                        kasiteltava = kasiteltava.getNextOikea();
                    }
                }
            }
        }
    }

    /**
     * Hakee mapista kyseisellä avaimella löytyvää arvoa
     *
     * @param avain Avain jolla haetaan
     * @return löydetty arvo tai null
     */
    public Comparable get(Comparable avain) {
        try {
            Arvopari<Comparable, Comparable> pari = haeArvopariAvaimenPerusteella(avain);
            if (pari == null) {
                return null;
            }
            return pari.getArvo();
        } catch (Exception e) {
            return null;
        }

    }

    public boolean containsKey(Comparable avain) {
        Arvopari<Comparable, Comparable> pari = haeArvopariAvaimenPerusteella(avain);
        if (pari == null) {
            return false;
        }
        return true;
    }

    public Arvopari haeArvopariAvaimenPerusteella(Comparable avain) {
        if (avain == null || juuri == null) {
            return null;
        }
        Arvopari<Comparable, Comparable> kasiteltava = juuri;
        while (kasiteltava != null) {
            int isompiko = kasiteltava.getAvain().compareTo(avain);
            if (isompiko == 0) {
                return kasiteltava;
            } else if (isompiko < 0) {
                kasiteltava = kasiteltava.getNextVasen();
            } else {
                kasiteltava = kasiteltava.getNextOikea();
            }
        }
        return null;
    }

    /**
     * Hakee jokaisen solmun yksitellen ja poistaa ne remove-metodilla
     */
    public void clear() {
        Arvopari<Comparable, Comparable> pari = null;
        while (juuri != null) {
            pari = palautaAlinSolmuMahdollisimmanVasemmalta();
            remove(pari.getAvain());
        }
    }

    public boolean remove(Comparable avain) {
        if (juuri == null) {
            return false;
        }
        Arvopari<Comparable, Comparable> kasiteltava = juuri;
        if (juuri.getAvain() == avain) {
            juuri = juuri.getNextOikea();
            poistaSolmuJaLisaaSenSolmutUuudelleenMappiin(kasiteltava);
            return true;
        }

        while (kasiteltava.getAvain() != null) {
            int isompiko = kasiteltava.getAvain().compareTo(avain);
            if (isompiko == 0) {
                return true;
            } else if (isompiko < 0) {
                if (kasiteltava.getNextVasen().getAvain() == avain) {
                    Arvopari poistettava = kasiteltava.getNextVasen();
                    kasiteltava.setNextVasen(null);
                    poistaSolmuJaLisaaSenSolmutUuudelleenMappiin(poistettava);
                    return true;
                }
                kasiteltava = kasiteltava.getNextVasen();
            } else {
                if (kasiteltava.getNextOikea().getAvain() == avain) {
                    Arvopari poistettava = kasiteltava.getNextOikea();
                    kasiteltava.setNextOikea(null);
                    poistaSolmuJaLisaaSenSolmutUuudelleenMappiin(poistettava);
                    return true;
                }
                kasiteltava = kasiteltava.getNextOikea();
            }
        }
        return false;
    }

    private void poistaSolmuJaLisaaSenSolmutUuudelleenMappiin(Arvopari kasiteltava) {
        Arvopari vasenSolmu = kasiteltava.getNextVasen();
        Arvopari oikeaSolmu = kasiteltava.getNextOikea();
        if (vasenSolmu != null) {
            putValmisArvopariMappiin(vasenSolmu);
        }
        if (oikeaSolmu != null) {
            putValmisArvopariMappiin(oikeaSolmu);
        }

        kasiteltava.setAvain(null);
        kasiteltava.setArvo(null);
    }

    /**
     * Palauttaa solmun, ensimmäisenä prioriteettina on että haetaan seuraava
     * solmu kunkin solmun vasemmalta puolelta. Jos solmun vasemmalla puolella
     * ei ole mitään, niin hakee solmun oikealta puolelta. Jos käsiteltävällä
     * solmulla ei ole oikealla eikä vasemmalla solmua, palauttaa return arvona
     * itsensä.
     *
     * @return Arvopari-tyyppinen solmu jolla ei ole solmua vasemmalla eikä
     * oikealla puolella
     */
    public Arvopari palautaAlinSolmuMahdollisimmanVasemmalta() {
        Arvopari<Comparable, Comparable> kasiteltava = juuri;
        if (juuri == null) {
            return null;
        }
        while (kasiteltava != null) {
            if (kasiteltava.getNextVasen() != null) {
                kasiteltava = kasiteltava.getNextVasen();
            } else if (kasiteltava.getNextOikea() != null) {
                kasiteltava = kasiteltava.getNextOikea();
            } else {
                return kasiteltava;
            }
         }
        return null;
    }

    public Setti keySet() {
        Setti<Comparable> setti = new Setti<Comparable>();
        if (juuri == null) {
            return setti;
        }
        Arvopari<Comparable, Comparable> kasiteltava = juuri;

        setti = lisaaSolmujenAvaimetSettiin(kasiteltava, setti);
        return setti;
    }

    protected Setti<Comparable> lisaaSolmujenAvaimetSettiin(Arvopari solmu, Setti setti) {
        if (solmu.getNextVasen() != null) {
            lisaaSolmujenAvaimetSettiin(solmu.getNextVasen(), setti);
        }
        if (solmu.getNextOikea() != null) {
            lisaaSolmujenAvaimetSettiin(solmu.getNextOikea(), setti);
        }
        setti.add(solmu.getAvain());
        return setti;
    }

    public Setti entrySet() {
        Setti<Comparable> setti = new Setti<Comparable>();
        if (juuri == null) {
            return setti;
        }
        Arvopari<Comparable, Comparable> kasiteltava = juuri;

        setti = lisaaSolmujenArvotSettiin(kasiteltava, setti);
        return setti;
    }

    protected Setti<Comparable> lisaaSolmujenArvotSettiin(Arvopari solmu, Setti setti) {
        if (solmu.getNextVasen() != null) {
            lisaaSolmujenArvotSettiin(solmu.getNextVasen(), setti);
        }
        if (solmu.getNextOikea() != null) {
            lisaaSolmujenArvotSettiin(solmu.getNextOikea(), setti);
        }
        setti.add(solmu.getArvo());
        return setti;
    }

    public boolean isEmpty() {
        if (juuri == null) {
            return true;
        }
        return false;
    }
}
