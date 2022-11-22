package com.example.saveasxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class SaveToXML {
   static private ObservableList<Pracownik> data = FXCollections.observableArrayList(
            new Pracownik("Jan", "Kowalski", 'M', "Stolarz",
                    LocalDate.of(2020, 2, 10), false),
            new Pracownik("Joanna", "Rakowska", 'K', "Piekarz",
                    LocalDate.of(2020, 9, 12), true),
            new Pracownik("Stefan", "Burczymucha", 'M', "Mechanik",
                    LocalDate.of(2020, 2, 10), false),
            new Pracownik("Jan", "Czekański", 'M', "Ślusarz",
                    LocalDate.of(2020, 9, 12), true),
            new Pracownik("Rafał", "Brudolf", 'M', "Ślusarz",
                    LocalDate.of(2020, 3, 18), true)
    );

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
//        https://docs.oracle.com/javase/8/docs/api/index.html?org/w3c/dom/package-summary.html
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        // Utworzenie dokumentu
        Document doc = dBuilder.newDocument();
        // Utworzenie korzenia o nazwie pracownicy
        Element rootElement = doc.createElement("Pracownicy");
        // Dodanie korzenia praciwnicy do dokumentu
        doc.appendChild(rootElement);
        // dla pracownika w liście:
        for (Pracownik elem : data) {
            // Dodanie nowej gałęzi Pracownik do korzenia Pracownicy
            Element pracownik = doc.createElement("Pracownik");
            rootElement.appendChild(pracownik);
            // Utworzenie nowej gałęzi imie
            Element imie = doc.createElement("imie");
            // Utworzenie wartości dla gałęzi i doadnie jej.
            imie.appendChild(doc.createTextNode(elem.getImie()));
            // Dodanie gałęzi imie do Pracownika
            pracownik.appendChild(imie);

            // Podobnie dla nazwiska płci i zawodu.
            Element nazwisko = doc.createElement("nazwisko");
            nazwisko.appendChild(doc.createTextNode(elem.getNazwisko()));
            pracownik.appendChild(nazwisko);
            Element plec = doc.createElement("plec");
            plec.appendChild(doc.createTextNode(Character.toString(elem.getPlec())));
            pracownik.appendChild(plec);
            Element zawod = doc.createElement("zawod");
            zawod.appendChild(doc.createTextNode(elem.getZawod()));
            pracownik.appendChild(zawod);
            Element dataUrodzenia = doc.createElement("dataUrodzenia");
            dataUrodzenia.appendChild(doc.createTextNode(elem.getData_urodzenia().toString()));
            pracownik.appendChild(dataUrodzenia);
            Element aktywnyZawodowo = doc.createElement("aktywnyZawodowo");
            aktywnyZawodowo.appendChild(doc.createTextNode(String.valueOf(elem.isAktywny_zawodowo())));
            pracownik.appendChild(aktywnyZawodowo);
        }


        // Zapis pliku XML
        FileOutputStream output = new FileOutputStream(".\\pracownicy.xml");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);


        // Odczyt pliku XML

        // wyczyszczenie listy
        data.clear();
        // Wywołanie matody loaxXML
        File file = new File(".\\pracownicy.xml");
        data = loadXML(file);
    }

    public static ObservableList<Pracownik> loadXML(File file)
            throws ParserConfigurationException, IOException, SAXException, IOException {
        // Podanie ścieżki do pliku
        // Utworzenie obiektów fabryki\
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        // Wypisanie korzenia
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        // Pobranie wezłów pracownik (lista pracowników)
        NodeList nList = doc.getElementsByTagName("Pracownik");
        System.out.println("----------------------------");
        // Utworzenie pustej listy w której będą ładowani pracownicy
        ObservableList<Pracownik> lista = FXCollections.observableArrayList();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            // utworzenie pustego pracownika którego pola będą uzupełniane w kolejnych
            // iteracjach i dodawane do listy
            Pracownik p1 = new Pracownik();
            org.w3c.dom.Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + ((org.w3c.dom.Node) nNode).getNodeName());
            if (((org.w3c.dom.Node) nNode).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // Ustawienie imienia w obiekcie pracownik
                p1.setImie(eElement.getElementsByTagName("imie").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("imie").item(0).getTextContent());
                p1.setNazwisko(eElement.getElementsByTagName("nazwisko").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("nazwisko").item(0).getTextContent());
                p1.setZawod(eElement.getElementsByTagName("zawod").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("zawod").item(0).getTextContent());
                // Konwersja string to char i zapis w obiekcie
                p1.setPlec(eElement.getElementsByTagName("plec").item(0).getTextContent().charAt(0));
                System.out.println(eElement.getElementsByTagName("plec").item(0).getTextContent().charAt(0));
                p1.setData_urodzenia(
                        LocalDate.parse(eElement.getElementsByTagName("dataUrodzenia").item(0).getTextContent()));
                System.out.println(LocalDate.parse(eElement.getElementsByTagName("dataUrodzenia").item(0).getTextContent()));
                p1.setAktywny_zawodowo(Boolean
                        .parseBoolean(eElement.getElementsByTagName("aktywnyZawodowo").item(0).getTextContent()));
                System.out.println(eElement.getElementsByTagName("aktywnyZawodowo").item(0).getTextContent());
                lista.add(p1);
            }
        }
        return lista;
    }
}
