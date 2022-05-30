package exceptions;

public class RepoException extends Exception{

    private String err;

    /**
     *
     *
     * @param err
     */
    public RepoException(String err) {
        this.err = err;
    }

    public String getErr() {
        return err;
    }
}
