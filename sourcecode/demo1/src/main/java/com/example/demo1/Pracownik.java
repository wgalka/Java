package com.example.demo1;

import java.time.LocalDate;

public class Pracownik {


    private String imie;
    private String nazwisko;
    private char plec;
    private String zawod;
    private LocalDate data_urodzenia;
    private boolean aktywny_zawodowo;

    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, char plec, String zawod, LocalDate data_urodzenia, boolean aktywny_zawodowo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.zawod = zawod;
        this.data_urodzenia = data_urodzenia;
        this.aktywny_zawodowo = aktywny_zawodowo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getZawod() {
        return zawod;
    }

    public void setZawod(String zawod) {
        this.zawod = zawod;
    }

    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(LocalDate data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public boolean isAktywny_zawodowo() {
        return aktywny_zawodowo;
    }

    public void setAktywny_zawodowo(boolean aktywny_zawodowo) {
        this.aktywny_zawodowo = aktywny_zawodowo;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec=" + plec +
                ", zawod='" + zawod + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", aktywny_zawodowo=" + aktywny_zawodowo +
                '}';
    }
}
