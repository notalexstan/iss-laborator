package model;

public abstract class Entity<ID> {

    private ID id;

    /**
     * Contructor Entity cu parametru id de tip ID
     * @param id de tip ID
     */
    public Entity(ID id) {
        this.id = id;
    }

    public Entity() {

    }

    /**
     * Getter pt id
     * @return id de tip ID
     */
    public ID getId() {
        return id;
    }

}
