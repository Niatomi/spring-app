package ru.niatomi.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.entity.User;
import ru.niatomi.repository.UserRepo;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping()
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Server works");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @PostMapping("/save")
    public ResponseEntity registration(@RequestBody User user) {
        try {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                return ResponseEntity.badRequest().body("User with name '" + user.getUsername() + "' already exists...");
            }
            userRepo.save(user);
            return ResponseEntity.ok("User saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

}
