package repository;

import exceptions.RepoException;
import model.Abonat;

import java.util.List;

public interface IDBAbonatRepo extends RepoInterface<Integer, Abonat> {
    @Override
    void add(Abonat abonat) throws RepoException;

    @Override
    Abonat findById(Integer integer) throws RepoException;

    @Override
    void modify(Abonat abonat) throws RepoException;

    @Override
    void delete(Integer integer) throws RepoException;

    @Override
    List<Abonat> getAll();

    @Override
    int size();
}
