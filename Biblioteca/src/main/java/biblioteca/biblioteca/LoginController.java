package biblioteca.biblioteca;

import control.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Abonat;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameBox;

    @FXML
    void onLoginClick(ActionEvent event) throws IOException {

        String username = usernameBox.getText();
        String password = passwordBox.getText();
        Abonat abonat = null;

        String err = "";
        if(username.length() == 0)
            err += "The username box must not be empty!\n";
        else if(password.length() == 0)
            err += "The password box must not be empty!\n";
        else {
            abonat = Controller.getInstance().login(username, password);
            if (abonat == null)
                err += "User does not exist!\n";
        }

        if(err.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(err);
            alert.show();
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(BibliotecaApplication.class.getResource("imprumuta_carti.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent, 600, 500);
            ImprumutaCartiController imprumutaCartiController = fxmlLoader.getController();


            Stage stage = (Stage) loginButton.getScene().getWindow();

            stage.setTitle("Imprumuta Carti");
            stage.setScene(scene);

            stage.setMinHeight(500);
            stage.setMinWidth(600);

            stage.setMaxHeight(500);
            stage.setMaxWidth(600);
            stage.show();
        }

    }

}
