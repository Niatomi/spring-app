package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.entity.TodoEntity;

/**
 * @author niatomi
 */
public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
