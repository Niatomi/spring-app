package ru.niatomi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.niatomi.entity.PasswordEntity;
import ru.niatomi.model.Password;
import ru.niatomi.model.PasswordWithOpenerId;
import ru.niatomi.repository.PasswordRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
@Service
public class ESPService {

    @Autowired
    PasswordRepository passwordRepository;

    public List<PasswordWithOpenerId> getPasswords() {
        List<PasswordWithOpenerId> passwordList = new ArrayList<PasswordWithOpenerId>();
        passwordRepository.findAll().forEach(p -> passwordList.add(new PasswordWithOpenerId(p.getOpener().getId(), p.getType(), p.getValue())));
        return passwordList;
    }
}
