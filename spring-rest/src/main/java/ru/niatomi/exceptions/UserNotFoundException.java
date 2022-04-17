package ru.niatomi.exceptions;

/**
 * @author niatomi
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super("User with id=" + id + "doesn't exists");
    }
}
