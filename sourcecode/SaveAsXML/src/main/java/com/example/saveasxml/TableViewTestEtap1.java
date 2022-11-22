package com.example.saveasxml;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.Date;

public class TableViewTestEtap1 extends Application {

    private ObservableList<Pracownik> data = FXCollections.observableArrayList(
            new Pracownik("Jan", "Kowalski", 'M', "Stolarz", LocalDate.of(2020, 2, 10), false),
            new Pracownik("Joanna", "Rakowska", 'K', "Piekarz", LocalDate.of(2020, 9, 12), true),
            new Pracownik("Stefan", "Burczymucha", 'M', "Mechanik", LocalDate.of(2020, 2, 10), false),
            new Pracownik("Jan", "Czekański", 'M', "Ślusarz", LocalDate.of(2020, 9, 12), true),
            new Pracownik("Rafał", "Brudolf", 'M', "Ślusarz", LocalDate.of(2020, 3, 18), true),
            new Pracownik("Miłosz", "Rudolf", 'M', "Mechanik", LocalDate.of(2020, 8, 21), false)
    );
    private TableView<Pracownik> table = new TableView<>();


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
        Scene scene = new Scene(vBox,800,800);
        primaryStage.setTitle("TableViewTest ASD");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
