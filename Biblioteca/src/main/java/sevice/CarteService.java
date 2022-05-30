package sevice;

import exceptions.BusinessException;
import exceptions.RepoException;
import exceptions.ValidateException;
import model.Carte;
import repository.RepoInterface;
import validate.Validator;

import java.util.ArrayList;

public class CarteService extends AbstractService<Integer, Carte> {
    public CarteService(RepoInterface<Integer, Carte> repository, Validator<Integer, Carte> validator) {
        super(repository, validator);
    }

    @Override
    public void add(ArrayList<Object> params) throws BusinessException, ValidateException, RepoException {

    }

    @Override
    public void update(ArrayList<Object> params) throws BusinessException, ValidateException, RepoException {

    }
}
