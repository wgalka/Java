module com.example.hibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    requires jakarta.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;


    requires java.sql;




    opens com.example.hibernate to javafx.fxml;
    opens com.example.hibernate.Models;
    exports com.example.hibernate;
}