package com.example.saveasxml;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class POJOBind {


    public static void main(String[] args) throws JAXBException, FileNotFoundException {



        List<Pracownik> prac = new ArrayList<Pracownik>();
        prac.add(new Pracownik("Jan", "Kowalski", 'M', "Stolarz", LocalDate.of(2020, 2, 10), false));
        prac.add(new Pracownik("Jan", "Kowalski", 'M', "Stolarz", LocalDate.of(2020, 2, 10), false));
        prac.add(new Pracownik("Joanna", "Rakowska", 'K', "Piekarz", LocalDate.of(2020, 9, 12), true));
        prac.add(new Pracownik("Stefan", "Burczymucha", 'M', "Mechanik", LocalDate.of(2020, 2, 10), false));
        prac.add(new Pracownik("Jan", "Czekański", 'M', "Ślusarz", LocalDate.of(2020, 9, 12), true));
        prac.add(new Pracownik("Rafał", "Brudolf", 'M', "Ślusarz", LocalDate.of(2020, 3, 18), true));
        prac.add(new Pracownik("Miłosz", "Rudolf", 'M', "Mechanik", LocalDate.of(2020, 8, 21), false));

        ListaPracownikow data = new ListaPracownikow();
        data.setPracownicy(prac);

        Helpers.ListPracToXML("test2", data);

        ListaPracownikow fromFileList= Helpers.XMLToPracList("test2.XML");
        System.out.println(fromFileList);
    }
}
