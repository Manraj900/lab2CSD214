module com.example.lab2manraj {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.lab2manraj to javafx.fxml;
    exports com.example.lab2manraj;
}