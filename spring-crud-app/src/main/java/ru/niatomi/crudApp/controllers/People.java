package ru.niatomi.crudApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.crudApp.dao.PersonDAO;
import ru.niatomi.crudApp.models.Person;

/**
 * @author niatomi
 */
@Controller
@RequestMapping("/people")
public class People {

    private PersonDAO personDAO;

    @Autowired
    public People(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String showPeople(Model model) {
        model.addAttribute("people", personDAO.showPeople());
        return "people/peopleShow";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id,
                             Model model) {
        model.addAttribute("person", personDAO.showPerson(id));
        return "people/person";
    }

    @GetMapping("/newPerson")
    public String createNewPerson(@ModelAttribute("person") Person person) {
        return "people/newPerson";
    }

    @PostMapping()
    public String addNewPersonToDB(@ModelAttribute("person") Person person) {
        personDAO.savePerson(person);
        return "redirect:people/";
    }
}
