package control;

import exceptions.BusinessException;
import exceptions.RepoException;
import exceptions.ValidateException;
import model.Abonat;
import model.Carte;
import repository.DBAbonatRepo;
import repository.DBCarteRepo;
import repository.RepoInterface;
import sevice.AbonatService;
import sevice.CarteService;
import sevice.Service;
import validate.AbonatValidator;
import validate.CarteValidator;
import validate.Validator;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

public class Controller {

    private static Controller controller = new Controller();
    private Service<Integer, Abonat> abonatService;
    private Service<Integer, Carte> carteService;


    private Controller()
    {
        Properties props=new Properties();
        try {
            props.load(new FileReader("D:\\Facultate\\An 2 Sem 2\\ISS\\LabISS\\Biblioteca\\src\\main\\resources\\bd.config.properties"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }

        RepoInterface<Integer, Abonat> abonatRepoInterface = new DBAbonatRepo(props);
        Validator<Integer, Abonat> abonatValidator = new Validator<>(new AbonatValidator());
        abonatService = new AbonatService(abonatRepoInterface, abonatValidator);

        RepoInterface<Integer, Carte> carteRepoInterface = new DBCarteRepo(props);
        Validator<Integer,Carte> carteValidator = new Validator<>(new CarteValidator());
        carteService = new CarteService(carteRepoInterface, carteValidator);

    }

    public static Controller getInstance() {
        return controller;
    }

    public Abonat login(String mail, String password)
    {
        List<Abonat> list = ((List<Abonat>) abonatService.getAll()).stream()
                .filter((x) -> Objects.equals(x.getMail(), mail)).collect(Collectors.toList());

        if(list.size() == 0)
            return null;

        Abonat abonat = list.get(0);

        if(!Objects.equals(password, abonat.getPassword()))
            return null;

        return abonat;
    }

    public List<Carte> getAllCarti() {

        return carteService.getAll();

    }
}
