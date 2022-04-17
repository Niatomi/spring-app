package ru.niatomi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.niatomi.entity.TodoEntity;
import ru.niatomi.entity.UserEntity;
import ru.niatomi.model.Todo;
import ru.niatomi.repository.TodoRepo;
import ru.niatomi.repository.UserRepo;

/**
 * @author niatomi
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todoEntity,
                           Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todoEntity.setUser(user);
        return Todo.toModel(todoRepo.save(todoEntity));

    }

    public Todo updateTodo(Long todoId) {
        TodoEntity todoEntity = todoRepo.findById(todoId).get();
        todoEntity.setCompleted(!todoEntity.isCompleted());
        return Todo.toModel(todoRepo.save(todoEntity));
    }

}
