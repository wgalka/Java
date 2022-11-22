package com.example.zadanie3;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "student")
public class Student {



    @XmlElement(name = "name")
    private String imie;
    @XmlElement(name = "lastname")
    private String nazwisko;
    @XmlAttribute(name = "id", required = true)
    private Integer nrAlbumu;
    @XmlElement(name = "birthdate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate dataUrodzenia;

    public Student() {
    }

    public Student(String imie, String nazwisko, Integer nrAlbumu, LocalDate dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrAlbumu = nrAlbumu;
        this.dataUrodzenia = dataUrodzenia;
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

    public Integer getNrAlbumu() {
        return nrAlbumu;
    }

    public void setNrAlbumu(Integer nrAlbumu) {
        this.nrAlbumu = nrAlbumu;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }
}
