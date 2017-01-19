package com.example.asuper.omnibus.Klasy;

/**
 * Created by super on 15.01.2017.
 */

public class Wynik {

    public int IdWyniku;// { get; set; }
    public int IdUzytkownika;// { get; set; }
    public int Punkty;// { get; set; }

    public Wynik(int idWyniku, int idUzytkownika, int punkty) {
        IdWyniku = idWyniku;
        IdUzytkownika = idUzytkownika;
        Punkty = punkty;
    }

    public Wynik(int idUzytkownika, int punkty) {
        IdUzytkownika = idUzytkownika;
        Punkty = punkty;
    }

    public int getIdWyniku() {
        return IdWyniku;
    }

    public void setIdWyniku(int idWyniku) {
        IdWyniku = idWyniku;
    }

    public int getIdUzytkownika() {
        return IdUzytkownika;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        IdUzytkownika = idUzytkownika;
    }

    public int getPunkty() {
        return Punkty;
    }

    public void setPunkty(int punkty) {
        Punkty = punkty;
    }
}
