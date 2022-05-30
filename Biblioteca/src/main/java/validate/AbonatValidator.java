package validate;


import exceptions.ValidateException;
import model.Abonat;

import java.util.Objects;

/**
 * valideaza un utilizator
 */
public class AbonatValidator implements Validation<Integer, Abonat> {
    private String message;

    /**
     * mesajul specific este intializat vid in constructor
     */
    public AbonatValidator() {
        message = "";
    }

    @Override
    public void genericValidate(Abonat abonat) throws ValidateException {
        message = "";
        if (abonat.getId() < 1)
            message += "Id invalid!\n";
        if (Objects.equals(abonat.getCnp(), ""))
            message += "Cnp invalid!\n";
        if (Objects.equals(abonat.getNume(), ""))
            message += "Nume invalid!\n";
        if (Objects.equals(abonat.getMail(), ""))
            message += "Mail invalid!\n";
        if (Objects.equals(abonat.getPassword(), ""))
            message += "Parola invalid!\n";
        if (message.length() > 0) {
            throw new ValidateException(message);
        }
    }
}
