package ru.niatomi.crudApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {

    private int id;
    private String name;
    private int age;
    private String email;

}
