package ru.niatomi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;

/**
 * @author niatomi
 */
@Service
public class ClientService {

    @Autowired
    private OpenerRepository openerRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    public OpenerEntity create(OpenerEntity openerEntity) throws OpenerAlreadyExistsException {
        return openerRepository.save(openerEntity);
    }
}


//    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
//        if (userRepo.findByUsername(user.getUsername()) != null) {
//            throw new UserAlreadyExistsException(user);
//        }
//        return userRepo.save(user);
//    }
