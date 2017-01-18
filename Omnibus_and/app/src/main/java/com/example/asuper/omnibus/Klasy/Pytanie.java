package com.example.asuper.omnibus.Klasy;

import java.io.Serializable;

/**
 * Created by super on 07.01.2017.
 */

public class Pytanie implements Serializable {

    public int IdPytania;// { get; set; }
    public int NrOdpPop;// { get; set; }
    public String Tekst;// { get; set; }

    public Pytanie(int idPytania, int nrOdpPop, String tekst) {
        IdPytania = idPytania;
        NrOdpPop = nrOdpPop;
        Tekst = tekst;
    }


    public int getIdPytania() {
        return IdPytania;
    }

    public void setIdPytania(int idPytania) {
        IdPytania = idPytania;
    }

    public int getNrOdpPop() {
        return NrOdpPop;
    }

    public void setNrOdpPop(int nrOdpPop) {
        NrOdpPop = nrOdpPop;
    }

    public String getTekst() {
        return Tekst;
    }

    public void setTekst(String tekst) {
        Tekst = tekst;
    }
}
