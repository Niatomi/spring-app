package ru.niatomi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.niatomi.entity.PasswordEntity;

import java.util.List;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class PasswordWithOpenerId {

    private Long openerId;
    private String type;
    private String value;

//    public static PasswordWithOpenerId toModel(PasswordEntity passwords) {
//    }
}
