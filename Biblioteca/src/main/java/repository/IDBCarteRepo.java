package repository;

import exceptions.RepoException;
import model.Carte;

import java.util.List;

public interface IDBCarteRepo extends RepoInterface<Integer, Carte> {
    @Override
    void add(Carte carte) throws RepoException;

    @Override
    Carte findById(Integer integer) throws RepoException;

    @Override
    void modify(Carte carte) throws RepoException;

    @Override
    void delete(Integer integer) throws RepoException;

    @Override
    List<Carte> getAll();

    @Override
    int size();
}
