package com.example.saveasxml;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.time.LocalDate;

@XmlRootElement(name = "pracownik")
@XmlType(propOrder = { "imie", "nazwisko", "plec", "zawod","data_urodzenia" ,"aktywny_zawodowo"})
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

    @XmlElement(name = "name")
    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @XmlElement(name = "surname")
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    @XmlElement(name = "gender")
    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getZawod() {
        return zawod;
    }

    @XmlElement(name = "profession")
    public void setZawod(String zawod) {
        this.zawod = zawod;
    }

    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    @XmlElement(name = "birthdate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setData_urodzenia(LocalDate data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public boolean isAktywny_zawodowo() {
        return aktywny_zawodowo;
    }

    @XmlElement(name = "professionally_active")
    public void setAktywny_zawodowo(boolean aktywny_zawodowo) {
        this.aktywny_zawodowo = aktywny_zawodowo;
    }



    public static void PracToXML(String filename, Pracownik prac) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Pracownik.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(prac, new File(filename+".XML"));
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

