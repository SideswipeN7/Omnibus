package com.example.asuper.omnibus.Klasy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by super on 15.01.2017.
 */

public class Zestaw implements Serializable {
    public  Pytanie pyt;// { get; set; }
    public ArrayList<Odpowiedz> odp;// { get; set; }

    public Zestaw(Pytanie pyt, ArrayList<Odpowiedz> odp) {
        this.pyt = pyt;
        this.odp = odp;
    }

    public Pytanie getPyt() {
        return pyt;
    }

    public void setPyt(Pytanie pyt) {
        this.pyt = pyt;
    }

    public ArrayList<Odpowiedz> getOdp() {
        return odp;
    }

    public void setOdp(ArrayList<Odpowiedz> odp) {
        this.odp = odp;
    }
}
