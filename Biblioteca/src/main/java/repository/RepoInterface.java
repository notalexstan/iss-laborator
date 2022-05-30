package repository;

import exceptions.RepoException;
import model.Entity;

import java.util.List;

public interface RepoInterface<ID, Obj extends Entity<ID>> {

    /**
     * Adauga un obiect in repo
     * @param obj
     * @throws RepoException
     */
    void add(Obj obj) throws RepoException;

    /**
     * Cauta un obiect din repo dupa id
     * @param id
     * @return obiectul cautat
     * @throws RepoException
     */
    Obj findById(ID id) throws RepoException;

    /**
     * Modifica un obiect existent din repo cu cel dat ca si param
     * @param obj
     * @throws RepoException
     */
    void modify(Obj obj) throws RepoException;

    /**
     * Sterge obiectul cu id-ul id
     * @param id
     * @throws RepoException
     */
    void delete(ID id) throws RepoException;

    /**
     * returneaza toate obiectele din repo sub forma unei colectii
     * @return toate obiectele
     */
    List<Obj> getAll();

    /**
     * Returneaza dimensiunea repo-ului
     * @return dimensiune - int
     */
    int size();

}
