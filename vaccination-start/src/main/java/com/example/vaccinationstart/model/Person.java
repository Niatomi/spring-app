package com.example.vaccinationstart.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Person {

    private UUID id;
    private String name;
    private List<Vaccination> vaccinations = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        id = UUID.randomUUID();
    }

    public boolean isFullyVaccinated() {
        return  vaccinations.stream().filter(vaccination -> vaccination.getStatus().equals(Vaccination.Status.PROVIDED)).count() == 2;
    }

}
