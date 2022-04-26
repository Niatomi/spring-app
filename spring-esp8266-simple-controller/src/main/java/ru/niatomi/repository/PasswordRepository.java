package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.niatomi.entity.PasswordEntity;

/**
 * @author niatomi
 */
public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {
}
