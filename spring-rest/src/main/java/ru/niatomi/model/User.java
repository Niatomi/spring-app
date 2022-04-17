package ru.niatomi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
    }
}
