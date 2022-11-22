package com.example.zadanie3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Helpers {
    public static void StudentsToXML(String filename, Students stud) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Students.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(stud, new File(filename + ".xml"));
    }

    public static Students XMLToStudents(String filename) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Students.class);
        return (Students) context.createUnmarshaller()
                .unmarshal(new FileReader(filename));
    }
}
