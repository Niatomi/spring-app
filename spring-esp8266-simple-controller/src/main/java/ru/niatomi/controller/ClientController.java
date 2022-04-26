package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.service.ClientService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody OpenerEntity openerEntity) {
        try {
            clientService.create(openerEntity);
            return ResponseEntity.ok("User saved");
        } catch (OpenerAlreadyExistsException e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

}
