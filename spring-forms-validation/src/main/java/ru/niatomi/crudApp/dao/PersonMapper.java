package ru.niatomi.crudApp.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.niatomi.crudApp.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author niatomi
 */
public class PersonMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt(1));
        person.setName(resultSet.getString(2));
        person.setAge(resultSet.getInt(3));
        person.setEmail(resultSet.getString(4));

        return person;
    }
}
