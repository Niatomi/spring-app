package ru.niatomi.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author niatomi
 */
@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }

}
