package com.example.saveasxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Helpers {
    public static void ListPracToXML(String filename, ListaPracownikow prac) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ListaPracownikow.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(prac, new File(filename + ".XML"));
    }

    public static ListaPracownikow XMLToPracList(String filename) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(ListaPracownikow.class);
        return (ListaPracownikow) context.createUnmarshaller()
                .unmarshal(new FileReader(filename));
    }
}
