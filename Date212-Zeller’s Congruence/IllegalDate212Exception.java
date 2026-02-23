/**
 * 
 * @author prabhjot kaur
 * CS 212 - Project 4
 * File: IllegalDate212Exception.java
 * Date: 15 December 2025
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

