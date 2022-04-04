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

        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
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

    public void changePerson(int id, Person updatedPerson) {
        Person updatingPerson = showPerson(id);
        updatingPerson.setName(updatedPerson.getName());
    }

    public void deletePerson(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
