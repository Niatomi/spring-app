package com.example.vaccinationstart.service;

import com.example.vaccinationstart.model.Person;
import com.example.vaccinationstart.model.Vaccination;
import com.example.vaccinationstart.model.Vaccine;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VaccinationService {

    private final List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public Person addPerson(String name) {
        Person person = new Person(name);
        persons.add(person);
        return person;
    }

    public Person scheduleVaccination(UUID personId, LocalDate localDate) {
        Person person = findPersonById(personId).orElseThrow(null);
        Vaccination vaccination;
        if (person.getVaccinations().isEmpty()) {
            vaccination = new Vaccination(localDate);
        } else {
            vaccination = new Vaccination(localDate, person.getVaccinations().get(0).getVaccine());
        }
        person.getVaccinations().add(vaccination);
        return person;
    }

    public String generateCertificate(UUID personId) {
        Person person = findPersonById(personId).orElseThrow(null);
        if (person.getVaccinations().size() == 2) {
            if (person.isFullyVaccinated()) {
                return String.format("Congratulation you got two hits of %s. Now you could travel", person.getVaccinations().get(0).getVaccine());
            } else {
                return "You've got scheduled vaccination. Please wait";
            }
        }
        return "You need vaccination";
    }

    private Optional<Person> findPersonById(UUID personId) {
        return persons.stream().filter(person -> person.getId().equals(personId)).findFirst();
    }


    //only for demo purpose
    public void generateTestData() {
        Person petro = new Person("Petro");
        petro.getVaccinations().add(new Vaccination(LocalDate.of(2021, 3, 8), Vaccine.ASTRA_ZENECA, Vaccination.Status.PROVIDED));
        petro.getVaccinations().add(new Vaccination(LocalDate.of(2021, 5, 10), Vaccine.ASTRA_ZENECA, Vaccination.Status.PROVIDED));
        persons.add(petro);
        Person anastasiia = new Person("Anastasiia");
        anastasiia.getVaccinations().add(new Vaccination(LocalDate.of(2021, 5, 22), Vaccine.PFIZER, Vaccination.Status.PROVIDED));
        anastasiia.getVaccinations().add(new Vaccination(LocalDate.of(2021, 6, 25), Vaccine.PFIZER, Vaccination.Status.SCHEDULED));
        persons.add(anastasiia);
        Person andriy = new Person("Andriy");
        andriy.getVaccinations().add(new Vaccination(LocalDate.of(2021, 2, 15), Vaccine.ASTRA_ZENECA, Vaccination.Status.PROVIDED));
        andriy.getVaccinations().add(new Vaccination(LocalDate.of(2021, 5, 27), Vaccine.ASTRA_ZENECA, Vaccination.Status.PROVIDED));
        persons.add(andriy);
        Person elina = new Person("Elina");
        elina.getVaccinations().add(new Vaccination(LocalDate.of(2021, 6, 11), Vaccine.SINOVAC, Vaccination.Status.PROVIDED));
        persons.add(elina);
        Person igor = new Person("Igor");
        persons.add(igor);
    }
}
