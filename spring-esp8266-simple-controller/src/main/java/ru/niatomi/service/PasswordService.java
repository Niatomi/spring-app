package ru.niatomi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.entity.PasswordEntity;
import ru.niatomi.model.Password;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;

/**
 * @author niatomi
 */
@Service
public class PasswordService {

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    private OpenerRepository openerRepository;

    public Password createPassword(PasswordEntity passwordEntity,
                                   Long openerId) {
        OpenerEntity opener = openerRepository.findById(openerId).get();
        passwordEntity.setOpener(opener);
        passwordRepository.save(passwordEntity);
        return new Password(passwordEntity.getId(), passwordEntity.getType(), passwordEntity.getValue());
    }
}

//    public Todo createTodo(TodoEntity todoEntity,
//                           Long userId) {
//        UserEntity user = userRepo.findById(userId).get();
//        todoEntity.setUser(user);
//        return Todo.toModel(todoRepo.save(todoEntity));
//
//    }
