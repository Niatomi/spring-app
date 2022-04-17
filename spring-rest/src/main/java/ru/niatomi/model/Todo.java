package ru.niatomi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.entity.TodoEntity;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    public static Todo toModel(TodoEntity todoEntity) {
        return new Todo(todoEntity.getId(), todoEntity.getTitle(), todoEntity.isCompleted());
    }
}
