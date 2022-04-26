package ru.niatomi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.niatomi.entity.OpenerEntity;

/**
 * @author niatomi
 */
public interface OpenerRepository extends CrudRepository<OpenerEntity, Long> {
}
