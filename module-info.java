module com.example.oopproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javafx.media;

    opens com.example.oopproject to javafx.fxml;
    exports com.example.oopproject;
    exports com.example.oopproject.MainController;
    opens com.example.oopproject.MainController to javafx.fxml;
    opens com.example.oopproject.Entity to com.fasterxml.jackson.datatype.jsr310, com.fasterxml.jackson.databind, javafx.fxml;
    exports com.example.oopproject.Entity;
    exports com.example.oopproject.Query;
}