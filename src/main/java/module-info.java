module com.tarsissarabia.javafx1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.tarsissarabia.javafx1 to javafx.fxml;
    exports com.tarsissarabia.javafx1;
}
