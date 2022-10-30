package by.sadovnick.moboperator.controller;

import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dto.TariffDto;

import java.util.List;

/**
 * Interface providing methods for working with the tariff controller layer.
 */
public interface TariffController extends MainController<Tariff>, MainControllerDto<TariffDto> {

    /**
     * Sort tariffs by subscription fee
     * @return sorted list of tariffs
     */
    List<Tariff> sortTariffBySubscription();

    /**
     * Get tariff from the list of tariffs based on the specified parameters.
     * @param priceMin minimal price
     * @param priceMax maximum price
     * @param freeMinutesMin minimal free minutes
     * @param freeMinutesMax maximum free minutes
     * @return tariff
     */
    Tariff getTariffsByPriceAndFreeMinutes(Double priceMin, Double priceMax,
                                           Integer freeMinutesMin, Integer freeMinutesMax);
}
