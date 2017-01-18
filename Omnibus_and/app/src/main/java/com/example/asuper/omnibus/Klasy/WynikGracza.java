package com.example.asuper.omnibus.Klasy;

/**
 * Created by super on 16.01.2017.
 */

public class WynikGracza {

    String Gracz;// { get; set; }
    int Punkty;// { get; set; }

    public WynikGracza(String gracz, int punkty) {
        Gracz = gracz;
        Punkty = punkty;
    }

    public String getGracz() {
        return Gracz;
    }

    public void setGracz(String gracz) {
        Gracz = gracz;
    }

    public int getPunkty() {
        return Punkty;
    }

    public void setPunkty(int punkty) {
        Punkty = punkty;
    }
}
