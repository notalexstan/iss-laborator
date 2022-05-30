package sevice;

import exceptions.BusinessException;
import exceptions.RepoException;
import exceptions.ValidateException;
import model.Entity;

import java.util.ArrayList;
import java.util.List;

public interface Service<ID, T extends Entity<ID>> {

    List<T> getAll();

    void add(ArrayList<Object> params) throws BusinessException, ValidateException, RepoException;

    void update(ArrayList<Object> params) throws BusinessException, ValidateException, RepoException;
}
