package by.sadovnick.moboperator.dao.repository;

import by.sadovnick.moboperator.dao.entity.Tariff;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository for working with the tariff entity in the database.
 * @see MainRepository
 * @see Tariff
 */
public interface TariffRepository extends MainRepository<Tariff> {
    /**
     * Search for a tariff for a given range of parameters.
     * @param priceMin minimal price
     * @param priceMax maximum price
     * @param freeMinutesMin minimal of free minutes
     * @param freeMinutesMax maximum of free minutes
     * @return tariff
     */
    @Query("SELECT t from Tariff t where t.price between ?1 and ?2 and t.freeMinutes between ?3 and ?4")
    Tariff findByPriceAndFreeMinutes(Double priceMin, Double priceMax,
                                     Integer freeMinutesMin, Integer freeMinutesMax);
}
