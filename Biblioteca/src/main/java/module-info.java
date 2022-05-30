module biblioteca.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;


    opens biblioteca.biblioteca to javafx.fxml;
    exports biblioteca.biblioteca;
}