package com.example.vaccinationstart.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Vaccination {

    public enum Status {SCHEDULED, PROVIDED}

    private LocalDate date;
    private Vaccine vaccine;
    private Status status;

    public Vaccination(LocalDate date, Vaccine vaccine, Status status) {
        this.date = date;
        this.vaccine = vaccine;
        this.status = status;
    }

    public Vaccination(LocalDate date, Vaccine vaccine) {
        this.date = date;
        this.vaccine = vaccine;
        status = Status.SCHEDULED;
    }

    public Vaccination(LocalDate date) {
        this.date = date;
        Vaccine[] vaccines = Vaccine.values();
        vaccine = vaccines[new Random().nextInt(vaccines.length)];
        status = Status.SCHEDULED;
    }
}
