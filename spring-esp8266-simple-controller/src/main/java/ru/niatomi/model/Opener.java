package ru.niatomi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.niatomi.entity.PasswordEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class Opener {
    private String firstName;
    private String secondName;
    private String thirdName;

    List<Password> todos;
}
