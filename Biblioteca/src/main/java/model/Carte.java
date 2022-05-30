package model;

public class Carte extends Entity<Integer> {
    private String titlu;
    private String autor;
    private Gen gen;
    private String isbm;
    private Status status;

    public Carte(Integer integer, String titlu, String autor, Gen gen, String isbm, Status status) {
        super(integer);
        this.titlu = titlu;
        this.autor = autor;
        this.gen = gen;
        this.isbm = isbm;
        this.status = status;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public Gen getGen() {
        return gen;
    }

    public String getIsbm() {
        return isbm;
    }

    public Status getStatus() {
        return status;
    }
}

