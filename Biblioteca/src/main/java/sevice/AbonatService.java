package sevice;

import exceptions.BusinessException;
import model.Abonat;
import repository.RepoInterface;
import validate.Validator;

import java.util.ArrayList;

public class AbonatService extends AbstractService<Integer, Abonat>{

    public AbonatService(RepoInterface<Integer, Abonat> repository, Validator<Integer, Abonat> validator) {
        super(repository, validator);
    }

    @Override
    public void add(ArrayList<Object> params) {

    }

    @Override
    public void update(ArrayList<Object> params) throws BusinessException {



    }
}
