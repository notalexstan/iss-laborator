package biblioteca.biblioteca;

import control.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Carte;
import model.Gen;

import java.util.List;

public class ImprumutaCartiController {

    @FXML
    private Button adaugaInCosButton;

    @FXML
    private TableColumn<Carte, String > autorColumn;

    @FXML
    private Button delogareButton;

    @FXML
    private TableColumn<Carte, String > genColumn;

    @FXML
    private TableView<Carte> tabelCarti;

    @FXML
    private TableColumn<Carte, String > titluColumn;

    @FXML
    private Button vizualizeazaCosButton;

    private Controller controller = Controller.getInstance();

    private void setController(Controller controller)
    {
        this.controller = controller;
    }

    @FXML
    public void initialize()
    {
        load();
        setController(Controller.getInstance());
    }

    private void load() {
        titluColumn.setCellValueFactory((data) -> new SimpleStringProperty(data.getValue().getTitlu()));
        autorColumn.setCellValueFactory((data) -> new SimpleStringProperty(data.getValue().getAutor()));
        genColumn.setCellValueFactory((data) -> new SimpleStringProperty(data.getValue().getGen().toString()));
        loadCarti();
    }

    private void loadCarti() {
        List<Carte> carti = null;
        carti = controller.getAllCarti();
        tabelCarti.setItems(FXCollections.observableList(carti));
    }


}