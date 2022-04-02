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
        Integer answer = 0;
        if (action == "multiplication") {
            answer = a * b;
            model.addAttribute("answer", answer);
        } else if (action == "addition") {
            System.out.println("You in logic");
            answer = a + b;
            model.addAttribute("answer", answer);
        } else if (action == "subtraction") {
            answer = a - b;
            model.addAttribute("answer", answer);
        } else if (action == "division") {
            answer = a / b;
            model.addAttribute("answer", answer);
        }
        return "first/calculator";
    }

}
