package com.example.vaccinationstart.controller;

import com.example.vaccinationstart.model.Person;
import com.example.vaccinationstart.service.VaccinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class VaccinationController {

    private final VaccinationService vaccinationService;

    @GetMapping("/persons")
    public RepresentationModel<CollectionModel<EntityModel<Person>>> getPersons() {
        List<EntityModel<Person>> collect = vaccinationService.getPersons().stream().map(EntityModel::of).collect(Collectors.toList());
        return CollectionModel.of(collect);
    }

    @PostMapping("/person")
    public EntityModel<Person> addPerson(@RequestParam String name) {
        return EntityModel.of(vaccinationService.addPerson(name));
    }

    @PostMapping(value = "/person/{personId}/vaccination")
    public EntityModel<Person> scheduleVaccination(@PathVariable(name = "personId") UUID personId,
                                                    @RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return EntityModel.of(vaccinationService.scheduleVaccination(personId, date));
    }

    @GetMapping(value = "/person/{personId}/generate-certificate")
    public EntityModel<ResponseMessage> generateCertificate(@PathVariable UUID personId) {
        ResponseMessage responseMessage = new ResponseMessage(vaccinationService.generateCertificate(personId));
        return EntityModel.of(responseMessage);
    }

    @PostMapping("/test-data")
    public void generateTestData() {
        vaccinationService.generateTestData();
    }
}
