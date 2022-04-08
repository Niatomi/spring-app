package ru.niatomi.crudApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.niatomi.crudApp.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
@Component
public class PersonDAO {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> showPeople() {
        return jdbcTemplate.query("SELECT * FROM Person",
                                    new BeanPropertyRowMapper<>(Person.class));
    }

    public Person showPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                                    new Object[]{id},
                                    new BeanPropertyRowMapper<>(Person.class))
                           .stream()
                           .findAny()
                           .orElse(null);
    }

    public void savePerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)",
                                    person.getName(),
                                    person.getAge(),
                                    person.getEmail());
    }

    public void changePerson(int id, Person changedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?,age=?, email=? WHERE id=?",
                changedPerson.getName(),
                changedPerson.getAge(),
                changedPerson.getEmail(),
                id);
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
