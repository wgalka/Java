package com.example.zadanie3;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Student s1 = new Student("Jan", "Kowalski", 1234567, LocalDate.of(2020, 10, 1));
        Student s2 = new Student("Krzysztof", "Nowak", 7654321, LocalDate.of(2020, 9, 1));

        Students students = new Students();
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        students.setStudenci(list);

        // Zapis studentów do pliku XML
        Helpers.StudentsToXML("studenci",students);

        // Odczyt z pliku
        students = Helpers.XMLToStudents("studenci.xml");
    }
}
