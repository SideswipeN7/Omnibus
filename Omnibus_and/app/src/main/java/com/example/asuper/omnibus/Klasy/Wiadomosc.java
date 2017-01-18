package com.example.asuper.omnibus.Klasy;

/**
 * Created by super on 15.01.2017.
 */

public class Wiadomosc {
    public boolean dane1;// { get; set; }
    public int dane2;// { get; set; }

    public Wiadomosc(boolean dane1, int dane2) {
        this.dane1 = dane1;
        this.dane2 = dane2;
    }

    public boolean getDane1() {
        return dane1;
    }

    public void setDane1(boolean dane1) {
        this.dane1 = dane1;
    }

    public int getDane2() {
        return dane2;
    }

    public void setDane2(int dane2) {
        this.dane2 = dane2;
    }
}
