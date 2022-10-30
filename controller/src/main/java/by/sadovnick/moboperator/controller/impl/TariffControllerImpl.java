package by.sadovnick.moboperator.controller.impl;

import by.sadovnick.moboperator.controller.TariffController;
import by.sadovnick.moboperator.dao.entity.Tariff;
import by.sadovnick.moboperator.dto.TariffDto;
import by.sadovnick.moboperator.service.TariffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link TariffController}
 *
 * @see TariffService
 */
@RestController
@RequestMapping(value = "/tariff")
@Tag(name = "Tariffs", description = "To work with tariffs")
public class TariffControllerImpl implements TariffController {

    private final TariffService tariffService;

    public TariffControllerImpl(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    /**
     * Save tariff dto
     *
     * @param tariffDto dto
     */
    @Override
    @PostMapping("/save")
    @Operation(summary = "Save tariff", description = "Save tariff to database")
    public void save(@RequestBody TariffDto tariffDto) {
        tariffService.save(tariffDto);
    }

    /**
     * Get tariff by id
     *
     * @param id entity id
     * @return tariff
     */
    @Override
    @GetMapping("/getByID")
    @Operation(summary = "Get tariff by ID", description = "Get tariff from database by ID")
    public Optional<Tariff> getById(@RequestParam Long id) {
        return tariffService.findById(id);
    }

    /**
     * Get all tariffs
     *
     * @return list of tariffs
     */
    @Override
    @GetMapping("/getAll")
    @Operation(summary = "Get all tariffs", description = "Get all tariffs from database")
    public Iterable<Tariff> getAll() {
        return tariffService.findAll();
    }

    /**
     * Delete tariff by id
     *
     * @param id tariff id
     */
    @Override
    @DeleteMapping("/deleteByID")
    @Operation(summary = "Delete tariff by ID", description = "Delete tariff from database by ID")
    public void deleteById(@RequestParam Long id) {
        tariffService.deleteById(id);
    }

    /**
     * Delete all tariffs
     */
    @Override
    @DeleteMapping("/deleteAll")
    @Operation(summary = "Delete all", description = "Delete clients from database")
    public void deleteAll() {
        tariffService.deleteAll();
    }

    /**
     * Sort list of tariffs by subscription fee
     *
     * @return sort list of tariffs
     */
    @Override
    @GetMapping("/getSortTariffBySubsription")
    @Operation(summary = "Sort tariffs", description = "Sort tariffs by subscription fee")
    public List<Tariff> sortTariffBySubscription() {
        return tariffService.sortTariffBySubscription();
    }

    /**
     * Get tariff from the list of tariffs based on the specified parameters.
     *
     * @param priceMin       minimal price
     * @param priceMax       maximum price
     * @param freeMinutesMin minimal free minutes
     * @param freeMinutesMax maximum free minutes
     * @return tariff
     */
    @Override
    @GetMapping("/getTariffByPriceAndFreeminutes")
    @Operation(summary = "Find the tariff corresponding to the specified range of parameters",
            description = "Parameter range - price and free minutes")
    public Tariff getTariffsByPriceAndFreeMinutes(@RequestParam Double priceMin,
                                                  @RequestParam Double priceMax,
                                                  @RequestParam Integer freeMinutesMin,
                                                  @RequestParam Integer freeMinutesMax) {
        return tariffService.findTariffByPriceAndFreeMinutes(priceMin, priceMax, freeMinutesMin, freeMinutesMax);
    }
}
