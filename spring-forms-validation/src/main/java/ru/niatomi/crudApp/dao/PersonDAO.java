package ru.niatomi.crudApp.dao;

import lombok.Getter;
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
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<Person> showPeople() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person showPerson(int id) {
//        return people.stream()
//                     .filter(person -> person.getId() == id)
//                     .findAny().orElse(null);
        return null;
    }

    public void savePerson(Person person) {

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePerson(int id, Person updatedPerson) {
//        Person updatingPerson = showPerson(id);
//        updatingPerson.setName(updatedPerson.getName());
//        updatingPerson.setEmail(updatedPerson.getEmail());
//        updatingPerson.setAge(updatedPerson.getAge());
    }

    public void deletePerson(int id) {
//        people.removeIf(p -> p.getId() == id);
    }
}
