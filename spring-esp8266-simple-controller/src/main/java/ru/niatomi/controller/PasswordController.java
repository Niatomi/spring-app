package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.entity.PasswordEntity;
import ru.niatomi.service.PasswordService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    PasswordService service;

    @PostMapping
    public ResponseEntity createPassword(@RequestBody PasswordEntity password,
                                         @RequestParam Long openerId) {
        try {
            return ResponseEntity.ok(service.createPassword(password, openerId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }


}
