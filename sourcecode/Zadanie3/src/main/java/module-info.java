module com.example.zadanie3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.xml.bind;
    requires jakarta.activation;

    opens com.example.zadanie3 to javafx.fxml, java.xml.bind;
    exports com.example.zadanie3;
}