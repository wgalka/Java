package com.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        TextField tekst = new TextField("Ustaw promien");
        tekst.setEditable(false);
        Circle kolo = new Circle(0,0,100);
        TextArea wartosc = new TextArea("");


        wartosc.setMaxSize(10,10);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                kolo.setRadius((double)t1);
                wartosc.setText(String.format("%.0f", t1));
            }
        });


        HBox uklad = new HBox(20);
        VBox vbox = new VBox(20);

        uklad.setAlignment(Pos.TOP_LEFT);
        uklad.getChildren().add(tekst);
        uklad.getChildren().add(slider);
        uklad.getChildren().add(wartosc);
        vbox.getChildren().add(uklad);
        vbox.getChildren().add(kolo);


        Scene scene = new Scene(vbox,700,300);
        stage.setScene(scene);
        stage.setTitle("KOŁO");
        stage.show();
    }
}
