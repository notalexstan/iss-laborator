module biblioteca.biblioteca_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens biblioteca.biblioteca_2 to javafx.fxml;
    exports biblioteca.biblioteca_2;
}