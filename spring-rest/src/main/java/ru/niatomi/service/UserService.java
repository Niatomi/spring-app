package ru.niatomi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niatomi.entity.UserEntity;
import ru.niatomi.exceptions.UserAlreadyExistsException;
import ru.niatomi.exceptions.UserNotFoundException;
import ru.niatomi.model.User;
import ru.niatomi.repository.UserRepo;

/**
 * @author niatomi
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException(user);
        }
        return userRepo.save(user);
    }

    public User getOneUser(Long id) throws UserNotFoundException {
        UserEntity userEntity = userRepo.findById(id).get();
        if (userEntity == null) {
            throw new UserNotFoundException(id);
        }
        return User.toModel(userEntity);
    }

    public String deleteUser(Long id) throws UserNotFoundException {
        userRepo.deleteById(id);
        return "User with id=" + id + " deleted";
    }
}
