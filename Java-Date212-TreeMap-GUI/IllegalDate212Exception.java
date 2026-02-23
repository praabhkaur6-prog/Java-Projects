/**
 * 
 * @author prabhjot kaur
 * IllegalDate212Exception
 *
 * Custom unchecked exception for the Date212 class.
 * This exception is thrown when a date string is invalid,
 * incorrectly formatted, or represents an impossible date.
 */
public class IllegalDate212Exception extends IllegalArgumentException {

    /**
     * Creates a new IllegalDate212Exception with no detail message.
     */
    public IllegalDate212Exception() {
        super();
    }

    /**
     * Creates a new IllegalDate212Exception with the specified detail message.
     * @param message The detail message for the exception.
     */
    public IllegalDate212Exception(String message) {
        super(message);
    }
}

