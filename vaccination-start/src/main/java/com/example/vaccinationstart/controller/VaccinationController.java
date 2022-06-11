package com.example.vaccinationstart.controller;

import com.example.vaccinationstart.model.Person;
import com.example.vaccinationstart.service.VaccinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class VaccinationController {

    private final VaccinationService vaccinationService;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return vaccinationService.getPersons();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestParam String name) {
        return vaccinationService.addPerson(name);
    }

    @PostMapping(value = "/person/{personId}/vaccination")
    public Person scheduleVaccination(@PathVariable(name = "personId") UUID personId,
                                                    @RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return vaccinationService.scheduleVaccination(personId, date);
    }

    @GetMapping(value = "/person/{personId}/generate-certificate")
    public ResponseMessage generateCertificate(@PathVariable UUID personId) {
        return new ResponseMessage(vaccinationService.generateCertificate(personId));
    }

    @PostMapping("/test-data")
    public void generateTestData() {
        vaccinationService.generateTestData();
    }
}
