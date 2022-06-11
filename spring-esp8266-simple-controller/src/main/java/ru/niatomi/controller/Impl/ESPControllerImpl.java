package ru.niatomi.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.model.ActionsHistory;
import ru.niatomi.service.ESPService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public class ESPControllerImpl {

    @Autowired
    ESPService service;

    @GetMapping
    public ResponseEntity getPasswords() {
        try {
            return ResponseEntity.ok(service.getPasswords());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @PostMapping
    public void addActions(@RequestBody ActionsHistory actionsHistory) {
        try {
            service.addAction(actionsHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
