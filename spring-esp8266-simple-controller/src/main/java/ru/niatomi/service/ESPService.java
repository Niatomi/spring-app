package ru.niatomi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.niatomi.entity.ActionsHistoryEntity;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.entity.PasswordEntity;
import ru.niatomi.model.ActionsHistory;
import ru.niatomi.model.Password;
import ru.niatomi.model.PasswordWithOpenerId;
import ru.niatomi.repository.ActionsHistoryRepository;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @author niatomi
 */
@Service
public class ESPService {

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    ActionsHistoryRepository actionsHistoryRepository;

    @Autowired
    OpenerRepository openerRepository;

    public List<PasswordWithOpenerId> getPasswords() {
        List<PasswordWithOpenerId> passwordList = new ArrayList<PasswordWithOpenerId>();
        passwordRepository.findAll().forEach(p -> passwordList.add(new PasswordWithOpenerId(p.getOpener().getId(), p.getType(), p.getValue())));
        return passwordList;
    }

    public void addAction(ActionsHistory actionsHistory) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        actionsHistoryRepository.save(
                new ActionsHistoryEntity(
                        actionsHistoryRepository.count() + 1,
                        openerRepository.findById(actionsHistory.getOpenerId()).get(),

                        actionsHistory.getDescription(),

                        LocalDateTime.now().format(format)));
    }
}
