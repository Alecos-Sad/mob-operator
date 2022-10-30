package by.sadovnick.moboperator.controller;

/**
 * Interface adds save method for dto.
 * @param <T> entity
 */
public interface MainControllerDto<T> {
    /**
     * Save dto
     * @param t dto
     */
    void save(T t);
}
