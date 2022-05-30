package sevice;

import model.Entity;
import repository.RepoInterface;
import validate.Validator;

import java.util.List;

public abstract class AbstractService<ID, T extends Entity<ID>> implements Service<ID,T>{

    protected RepoInterface<ID,T> repository;
    protected Validator<ID, T> validator;

    public AbstractService(RepoInterface<ID, T> repository, Validator<ID, T> validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<T> getAll() {
        return repository.getAll();
    }

}
