package com.example.hibernate;

import com.example.hibernate.Models.Powiat;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Configuration configuration =
                new Configuration().configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();

        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Powiat pow1 = new Powiat("Rzeszowski");
        Powiat pow2 = new Powiat("Lubaczowski");
        session.persist(pow1);
        session.persist(pow2);

        transaction.commit();
        session.close();
        factory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);

        launch();
    }
}