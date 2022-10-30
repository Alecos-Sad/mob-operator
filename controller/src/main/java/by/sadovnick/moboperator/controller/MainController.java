package by.sadovnick.moboperator.controller;

import java.util.Optional;

/**
 * Interface providing basic methods for working with the controller layer
 * @param <T> entities
 */
public interface MainController <T>{
    /**
     * Get entity by id
     * @param id entity id
     * @return entity
     */
    Optional<T> getById(Long id);

    /**
     * Get all entities
     * @return list of entities
     */
    Iterable<T> getAll();

    /**
     * Delete entity by id
     * @param id entity id
     */
    void deleteById(Long id);

    /**
     * Delete all entities
     */
    void deleteAll();
}
