package ru.niatomi.crudApp.dao;

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

        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {

            connection = getConnection();

            statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            resultSet = statement.executeQuery(SQL);

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
        } finally {
            try {
                if (statement !=null) {
                    statement.close();
                }
                if (connection!=null) {
                    connection.close();
                }
                if (resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return people;
    }

    public Person showPerson(int id) {
        Person person = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String SQL = "SELECT * FROM Person WHERE id=?";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setAge(resultSet.getInt(3));
            person.setEmail(resultSet.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (resultSet!=null){
                    resultSet.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return person;
    }

    public void savePerson(Person person) {
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String SQL = "INSERT INTO Person VALUES(1, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void changePerson(int id, Person updatedPerson) {
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String SQL = "UPDATE Person SET name=?,age=?, email=? WHERE id=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deletePerson(int id) {
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String SQL = "DELETE FROM Person WHERE id=?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
