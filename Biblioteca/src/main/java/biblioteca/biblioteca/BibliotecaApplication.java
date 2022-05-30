package biblioteca.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BibliotecaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BibliotecaApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.setMinHeight(500);
        stage.setMinWidth(600);
        stage.setMaxHeight(500);
        stage.setMaxWidth(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}