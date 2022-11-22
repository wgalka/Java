package com.example.saveasxml;

import com.example.saveasxml.Pracownik;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Test1 extends Application {

    private ObservableList<Pracownik> data = FXCollections.observableArrayList(
            new Pracownik("Jan","Kowalski",'M',"Stolarz", LocalDate.of(2020,2,10), false),
            new Pracownik("Joanna","Rakowska",'K',"Piekarz",LocalDate.of(2020,9,12),true),
            new Pracownik("Stefan","Burczymucha",'M',"Mechanik",LocalDate.of(2020,2,10),false),
            new Pracownik("Jan","Czekański",'M',"Ślusarz",LocalDate.of(2020,9,12),true),
            new Pracownik("Rafał","Brudolf",'M',"Ślusarz",LocalDate.of(2020,3,18),true),
            new Pracownik("Krystian","Dziura",'M',"Informatyk",LocalDate.of(2001,11,10),false),
            new Pracownik("Bogdan","Siek",'M',"Nauczyciel",LocalDate.of(2020,7,29),true),
            new Pracownik("Magdalena","Kuliś",'K',"Kasjer",LocalDate.of(2020,8,12),true),
            new Pracownik("Klara","Ćwik",'K',"Policjant",LocalDate.of(2020,4,2),false),
            new Pracownik("Luborada","Bartkiewicz",'K', "Strażak",LocalDate.of(2020,4,30),true),
            new Pracownik("Pelagiusz","Świątczak",'M',"Budowlaniec",LocalDate.of(2020,8,20),false),
            new Pracownik("Aurelia","Warszawska",'K',"Strażak",LocalDate.of(2020,1,30),false),
            new Pracownik("Eliza","Kotula",'K',"Nauczyciel",LocalDate.of(2020,7,10),true),
            new Pracownik("Hadrian","Drewniak",'M',"Kelner",LocalDate.of(2020,10,13),true),
            new Pracownik("Sylwan","Błoch",'M',"Kucharz",LocalDate.of(2020,6,28),false),
            new Pracownik("Rodzisława","Piechowiak",'K',"Kucharz",LocalDate.of(2020,3,29),false),
            new Pracownik("Bożan", "Makówka",'M',"Taksówkarz",LocalDate.of(2019,10,29),false)
    );

    private final TableView<Pracownik> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(10);

        // Kolumna imię
        TableColumn<Pracownik, String> imieCol = new TableColumn<Pracownik, String>("Imię");
        imieCol.setMinWidth(100);
        imieCol.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );

        // Kolumna nazwisko
        TableColumn<Pracownik, String> nazwiskoCol = new TableColumn<Pracownik, String>("Nazwisko");
        nazwiskoCol.setMinWidth(100);
        nazwiskoCol.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );

        // Kolumna płeć
        TableColumn<Pracownik, String> plecCol = new TableColumn<Pracownik, String>("Płeć");
        plecCol.setMinWidth(100);
        plecCol.setCellValueFactory(
                new PropertyValueFactory<>("plec")
        );

        // Kolumna zawód
        TableColumn zawodCol = new TableColumn("zawód");
        zawodCol.setMinWidth(100);
        zawodCol.setCellValueFactory(
                new PropertyValueFactory<>("zawod")
        );

        // Kolumna data urodzenia
        TableColumn<Pracownik, Void> dataUrodzeniaCol = new TableColumn<>("Data urodzenia");
        dataUrodzeniaCol.setMinWidth(100);
        dataUrodzeniaCol.setCellValueFactory(
                new PropertyValueFactory<>("data_urodzenia")
        );

        // Kolumna aktywności zawodowej
        TableColumn aktywnyZawodowoCol = new TableColumn("Aktywny zawodowo");
        aktywnyZawodowoCol.setMinWidth(150);
        aktywnyZawodowoCol.setCellValueFactory(
                new PropertyValueFactory<>("aktywny_zawodowo")
        );

        table.setItems(data);
        table.getColumns().addAll(imieCol,nazwiskoCol,plecCol,zawodCol,dataUrodzeniaCol,aktywnyZawodowoCol);

        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox, 650, 650);
        primaryStage.setTitle("Tabela pracowników");
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
