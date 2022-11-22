module com.example.saveasxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    requires java.xml.bind;
    requires jakarta.activation;

    opens com.example.saveasxml to javafx.fxml, java.xml.bind;

    exports com.example.saveasxml;
}