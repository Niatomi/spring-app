package ru.niatomi.crudApp.dao;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.niatomi.crudApp.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    public PersonDAO() {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Jay"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Sam"));
        people.add(new Person(++PEOPLE_COUNT, "Willy"));
    }

    public List<Person> showPeople() {
        return people;
    }

    public Person showPerson(int id) {
        return people.stream()
                     .filter(person -> person.getId() == id)
                     .findAny().orElse(null);
    }

    public void savePerson(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
