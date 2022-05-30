package exceptions;

public class ValidateException extends Exception {
    /**
     * @param message mesaj specific contextului generat de validitatea elementului verificat
     */
    public ValidateException(String message) {
        super(message);
    }
}
