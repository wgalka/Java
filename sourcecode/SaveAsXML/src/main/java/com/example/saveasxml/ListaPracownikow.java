package com.example.saveasxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "pracownicy")
public class ListaPracownikow {

    @XmlElement(name = "pracownik", type = Pracownik.class)
    private List<Pracownik> praclist = new ArrayList<Pracownik>();

    public ListaPracownikow() {
    }

    public List<Pracownik> getPracownicy() {
        return praclist;
    }

    @XmlElement(name = "pracownicy")
    public void setPracownicy(List<Pracownik> pracownicy) {
        this.praclist = pracownicy;
    }

    @Override
    public String toString() {
        return "ListaPracownikow{" +
                "praclist=" + praclist +
                '}';
    }
}
