package com.example.asuper.omnibus.Klasy;

/**
 * Created by super on 07.01.2017.
 */

public class Uzytkownik {
    public int IdUzytkownika;// { get; set; }
    public String Nazwa;// { get; set; }
    public String Haslo;// { get; set; }

    public Uzytkownik(int idUzytkownika, String nazwa, String haslo) {
        IdUzytkownika = idUzytkownika;
        Nazwa = nazwa;
        Haslo = haslo;
    }

    public Uzytkownik(String nazwa, String haslo) {
        Nazwa = nazwa;
        Haslo = haslo;
    }

    public int getIdUzytkownika() {
        return IdUzytkownika;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        IdUzytkownika = idUzytkownika;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }

}
