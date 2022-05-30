package model;

public class Abonat extends Entity<Integer>{
    private String cnp;
    private String nume;
    private String mail;
    private String password;

    public Abonat(Integer integer, String cnp, String nume, String mail, String password) {
        super(integer);
        this.cnp = cnp;
        this.nume = nume;
        this.mail = mail;
        this.password = password;
    }

    public Abonat() {

    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getCnp() {
        return cnp;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return mail + " " + password;
    }
}
