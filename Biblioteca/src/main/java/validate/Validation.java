package validate;

import exceptions.ValidateException;
import model.Entity;

/**
 * @param <Id> id-ul generic al unui element
 * @param <T>  instanta a clasei Identifiable
 *             valideaza un element generic folosind logica strategy pattern
 */
public interface Validation<Id, T extends Entity<Id>> {
    /**
     * @param t elementul generic care va fi validat
     * @throws ValidateException exceptie aruncata daca elementul generic nu este valid (de la caz la caz)
     */
     void genericValidate(T t) throws ValidateException;
}
