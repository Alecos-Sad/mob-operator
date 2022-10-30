package by.sadovnick.moboperator.service;

import java.util.Optional;

/**
 * Interface providing basic methods for working with the service layer
 *
 * @param <T> entities.
 */
public interface MainService<T> {
    /**
     * Finding entity by id in database.
     *
     * @param id entity id
     * @return entity
     */
    Optional<T> findById(Long id);

    /**
     * Finding all entities in database.
     *
     * @return list of entities
     */
    Iterable<T> findAll();

    /**
     * Delete entity from database.
     *
     * @param id entity id
     */
    void deleteById(Long id);

    /**
     * Delete all entity from database
     */
    void deleteAll();
}
