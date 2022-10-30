package by.sadovnick.moboperator.service.impl;

import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dao.repository.TariffRepository;
import by.sadovnick.moboperator.dto.TariffDto;
import by.sadovnick.moboperator.mapper.TariffMapper;
import by.sadovnick.moboperator.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of TariffService
 * @see TariffService
 * @see TariffRepository
 * @see TariffMapper
 */
@AllArgsConstructor
@Service
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;

    /**
     * Save dto to database
     * @param tariffDto dto
     * @return dto
     */
    @Override
    public TariffDto save(TariffDto tariffDto) {
        tariffRepository.save(tariffMapper.tariffDtoToTariff(tariffDto));
        return tariffDto;
    }

    /**
     * Finding tariff by id in database
     * @param id tariff id
     * @return tariff
     */
    @Override
    public Optional<Tariff> findById(Long id) {
        if (isExistById(id)){
            tariffRepository.findById(id);
        } else {
            throw new EntityNotFoundException();
        }
        return tariffRepository.findById(id);
    }

    /**
     * Finding all tariffs in database
     * @return list of tariffs
     */
    @Override
    public Iterable<Tariff> findAll() {
        return tariffRepository.findAll();
    }

    /**
     * Delete tariff by id from database
     * @param id tariff id
     */
    @Override
    public void deleteById(Long id) {
        if (isExistById(id)){
            tariffRepository.findById(id);
        } else {
            throw new EntityNotFoundException();
        }
        tariffRepository.deleteById(id);
    }

    /**
     * Delete all tariffs from database
     */
    @Override
    public void deleteAll() {
        tariffRepository.deleteAll();
    }

    /**
     * Сhecks if the tariff with this id is in the database
     * @param id tariff id
     * @return boolean
     */
    public boolean isExistById(Long id) {
        return tariffRepository.existsById(id);
    }
    /**
     * Sort tariffs in database by subscription fee
     * @return sort tariff list
     */
    @Override
    public List<Tariff> sortTariffBySubscription() {
        List<Tariff> tariffs = (List<Tariff>) tariffRepository.findAll();
        tariffs.sort(Tariff::compareTo);
        return tariffs;
    }

    /**
     * Find a tariff from the list of tariffs based on the specified parameters.
     * @param priceMin minimal price
     * @param priceMax maximum price
     * @param freeMinutesMin minimal free minutes
     * @param freeMinutesMax maximum free minutes
     * @return tariff
     */
    @Override
    public Tariff findTariffByPriceAndFreeMinutes(Double priceMin, Double priceMax,
                                                  Integer freeMinutesMin, Integer freeMinutesMax) {
        return tariffRepository.findByPriceAndFreeMinutes(priceMin, priceMax, freeMinutesMin, freeMinutesMax);
    }
}


