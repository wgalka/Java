/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



/**
 *
 * @author student
 */
public class Laboratorium5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle prostokat = new Rectangle();
        prostokat.setWidth(200);
        prostokat.setHeight(100);
        prostokat.setX(200);
        prostokat.setY(200);


        Circle kolo = new Circle();
        kolo.setCenterX(200.0f);
        kolo.setCenterY(200.0f);
        kolo.setRadius(50);

        // klasa Vbox ustawia elementy jeden pod drugim
//        VBox root = new VBox();

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Group.html
        Group root = new Group();
        ObservableList<Node> listaElementow = root.getChildren();
        listaElementow.add(kolo);
        listaElementow.add(prostokat);

        Scene scene = new Scene(root, 800, 800);

        primaryStage.setTitle("Hello world!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}