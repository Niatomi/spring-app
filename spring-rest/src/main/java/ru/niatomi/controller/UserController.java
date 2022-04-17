package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.entity.UserEntity;
import ru.niatomi.exceptions.UserAlreadyExistsException;
import ru.niatomi.exceptions.UserNotFoundException;
import ru.niatomi.service.UserService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.getOneUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            service.registration(userEntity);
            return ResponseEntity.ok("User saved");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.deleteUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

}
