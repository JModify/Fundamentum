package com.modify.fundamentum.exceptions;

/**
 * Exception can be thrown during any function where a player cannot be retrieved.
 */
public class PlayerNotFoundException extends Exception{

    /**
     * Send an exception without error message.
     */
    public PlayerNotFoundException() {
        super();
    }

    /**
     * Send this exception with an error message.
     * @param message error message to send.
     */
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
