package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.entity.User;

/**
 * @author niatomi
 */
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
