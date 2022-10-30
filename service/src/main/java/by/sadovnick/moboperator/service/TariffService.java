package by.sadovnick.moboperator.service;

import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dto.TariffDto;

import java.util.List;

/**
 * Interface providing methods for working with the tariff service layer.
 */
public interface TariffService extends MainService<Tariff>, MainServiceDto<TariffDto> {
    /**
     * Sort list of tariffs by subscription fee
     * @return list of tariffs
     */
    List<Tariff> sortTariffBySubscription();

    /**
     * Provides a tariff from the list of tariffs based on the specified parameters.
     * @param priceMin minimal price
     * @param priceMax maximum price
     * @param freeMinutesMin minimal free minutes
     * @param freeMinutesMax maximum free minutes
     * @return tariff
     */
    Tariff findTariffByPriceAndFreeMinutes(Double priceMin, Double priceMax,
                                           Integer freeMinutesMin, Integer freeMinutesMax);
}
