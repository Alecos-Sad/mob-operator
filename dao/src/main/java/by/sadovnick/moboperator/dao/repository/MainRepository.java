package by.sadovnick.moboperator.dao.repository;

import by.sadovnick.moboperator.dao.entity.parent.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository from which other repositories inherit to work with entities in the database.
 * @param <E> entity class parameter.
 */
@NoRepositoryBean
public interface MainRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {
}
