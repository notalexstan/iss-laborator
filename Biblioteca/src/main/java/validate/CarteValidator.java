package validate;

import exceptions.ValidateException;
import model.Carte;
import model.Gen;
import model.Status;

import java.util.Objects;

public class CarteValidator implements Validation<Integer, Carte> {
    private String  message;

    public CarteValidator() {
        this.message = "";
    }



    private static <E extends Enum< E > > boolean isInEnum(E value, Class<E> enumClass) {
        E[] values = enumClass.getEnumConstants();
        for (E val : values) {
            if(val.equals(value))
            { return true; }
        }
        return false;
    }

    @Override
    public void genericValidate(Carte carte) throws ValidateException {
        message = "";
        if(carte.getId()<1)
            message += "Id invalid\n";
        if(Objects.equals(carte.getTitlu(), ""))
            message += "Titlu invalid\n";
        if(Objects.equals(carte.getAutor(), ""))
            message += "Autor invalid\n";
        if(isInEnum(carte.getGen(), Gen.class))
            message += "Gen invalid\n";
        if(Objects.equals(carte.getIsbm(), ""))
            message += "ISBM invalid\n";
        if(isInEnum(carte.getStatus(), Status.class))
            message += "Status invalid\n";
        if (message.length() > 0) {
            throw new ValidateException(message);
        }
    }
}
