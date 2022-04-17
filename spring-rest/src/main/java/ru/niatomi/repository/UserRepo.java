package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.entity.UserEntity;

/**
 * @author niatomi
 */
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
