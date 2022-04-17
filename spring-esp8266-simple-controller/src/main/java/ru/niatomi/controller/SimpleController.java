package ru.niatomi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author niatomi
 */
@Controller
@RequestMapping("/esp")
public class SimpleController {

    @GetMapping
    public ResponseEntity pingSpring() {
        return ResponseEntity.ok("It works... for now");
    }

}
