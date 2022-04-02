package ru.niatomi.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author niatomi
 */
@Controller
@RequestMapping("/first")
public class Calculator {

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        if (action.equals("multiplication")) {
            model.addAttribute("answer", a * b);
        } else if (action.equals("addition")) {
            model.addAttribute("answer", a + b);
        } else if (action.equals("subtraction")) {
            model.addAttribute("answer", a - b);
        } else if (action.equals("division")) {
            model.addAttribute("answer", a / b);
        } else {
            model.addAttribute("answer", "There is no any actions like " + action);
        }

        return "first/calculator";
    }

}
