package by.sadovnick.moboperator.controller.impl;

import by.sadovnick.moboperator.controller.UserOperatorController;
import by.sadovnick.moboperator.dao.entity.UserOperator;
import by.sadovnick.moboperator.dto.UserOperatorDto;
import by.sadovnick.moboperator.service.UserOperatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Implementation of {@link UserOperatorController}
 * @see UserOperatorService
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/userOperator")
@Tag(name = "UserOperator", description = "to work with User Operator entity")
public class UserOperatorControllerImpl implements UserOperatorController {

    private final UserOperatorService userOperatorService;

    /**
     * Save user operator dto
     * @param userOperatorDto dto
     */
    @Override
    @PostMapping("/saveUserOperator")
    @Operation(summary = "Add user operator", description = "add user operator to database")
    public void save(@RequestBody UserOperatorDto userOperatorDto) {
        userOperatorService.save(userOperatorDto);
    }

    /**
     * Get user operator by id
     * @param id user operator id
     * @return user operator
     */
    @Override
    @GetMapping("/getByID")
    @Operation(summary = "Get user operators by ID", description = "get user operators from database by ID")
    public Optional<UserOperator> getById(@RequestParam Long id) {
        return userOperatorService.findById(id);
    }

    /**
     * Get all user operators
     * @return list of user operators
     */
    @Override
    @GetMapping("/getAll")
    @Operation(summary = "Get all user operators", description = "get all user operators from database")
    public Iterable<UserOperator> getAll() {
        return userOperatorService.findAll();
    }

    /**
     * Add tarif to user operator
     * @param userOperatorId id of user operator
     * @param tariffId       id of tariff
     */
    @Override
    @PostMapping("/addTariff")
    @Operation(summary = "Add tariff to user operator", description = "Add tariff to user operator database")
    public void addTariffByIdToUserOperator(Long userOperatorId, Long tariffId) {
        userOperatorService.addTariffByIdToUserOperator(userOperatorId, tariffId);
    }

    /**
     * Delete user operator by id
     * @param id user operator id
     */
    @Override
    @DeleteMapping("/deleteByID")
    @Operation(summary = "Delete user operators by ID", description = "Delete user operators from database by ID")
    public void deleteById(@RequestParam Long id) {
        userOperatorService.deleteById(id);
    }

    /**
     * Delete all user operators
     */
    @Override
    @DeleteMapping("/deleteAll")
    @Operation(summary = "Delete all  user operators", description = "Delete all user operators from database by ID")
    public void deleteAll() {
        userOperatorService.deleteAll();
    }

    /**
     * Replenish balance to user operator by id
     * @param id    id of user operator
     * @param summa amount funds
     */
    @Override
    @PostMapping("/replenishBalance")
    @Operation(summary = "Replenish balance", description = "Repleish balance to user operator by id")
    public void replenishTheBalanceById(@RequestParam Long id, @RequestParam Double summa) {
        userOperatorService.replenishTheBalanceById(id, summa);
    }

    /**
     * Get status from external microservice
     * @param status request status
     * @return request
     */
    @GetMapping("/getStatus")
    public String getStatus(@RequestParam String status) {
        return userOperatorService.getStatus(status);
    }
}
