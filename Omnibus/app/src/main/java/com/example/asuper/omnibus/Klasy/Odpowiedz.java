package com.example.asuper.omnibus.Klasy;

import java.io.Serializable;

/**
 * Created by super on 07.01.2017.
 */

public class Odpowiedz implements Serializable {
    public int IdOdpowiedzi;// { get; set; }
    public int IdPytania;// { get; set; }
    public String Tekst;// { get; set; }
    public int NrOdpowiedzi;// { get; set; }

    public Odpowiedz(int idOdpowiedzi, int idPytania, String tekst, int nrOdpowiedzi) {
        IdOdpowiedzi = idOdpowiedzi;
        IdPytania = idPytania;
        Tekst = tekst;
        NrOdpowiedzi = nrOdpowiedzi;
    }

    public int getIdOdpowiedzi() {
        return IdOdpowiedzi;
    }

    public void setIdOdpowiedzi(int idOdpowiedzi) {
        IdOdpowiedzi = idOdpowiedzi;
    }

    public int getIdPytania() {
        return IdPytania;
    }

    public void setIdPytania(int idPytania) {
        IdPytania = idPytania;
    }

    public String getTekst() {
        return Tekst;
    }

    public void setTekst(String tekst) {
        Tekst = tekst;
    }

    public int getNrOdpowiedzi() {
        return NrOdpowiedzi;
    }

    public void setNrOdpowiedzi(int nrOdpowiedzi) {
        NrOdpowiedzi = nrOdpowiedzi;
    }
}
