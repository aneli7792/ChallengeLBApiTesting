package exceptions;

public class ValueIsDifferent extends AssertionError {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public ValueIsDifferent(String message, Throwable cause) {
        super(message, cause);
    }
}