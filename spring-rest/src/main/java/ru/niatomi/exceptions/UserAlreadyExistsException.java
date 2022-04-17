package ru.niatomi.exceptions;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.stereotype.Controller;
import ru.niatomi.entity.UserEntity;

/**
 * @author niatomi
 */
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(UserEntity user) {
        super("User with name '" + user.getUsername() + "' already exists...");
    }
}
