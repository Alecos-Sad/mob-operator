package by.sadovnick.moboperator.service;

/**
 * Interface adds save method for dto.
 * @param <T> entity
 */
public interface MainServiceDto <T>{
    /**
     * Save entity in database
     * @param t entity
     * @return entity
     */
    T save(T t);
}
