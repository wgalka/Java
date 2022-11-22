module com.example.jaxb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jaxb to javafx.fxml;
    exports com.example.jaxb;
}