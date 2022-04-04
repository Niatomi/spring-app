package ru.niatomi.crudApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 32, message = "Name should be between 2 and 32 chars")
    private String name;

    @Min(value = 0, message = "Age should be greater than zero")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

}
