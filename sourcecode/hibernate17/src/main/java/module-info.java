module com.example.hibernate17 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;

    opens com.example.hibernate17 to javafx.fxml;
    exports com.example.hibernate17;
}