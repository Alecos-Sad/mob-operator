package by.sadovnick.moboperator.controller;

import by.sadovnick.moboperator.dao.entity.UserOperator;
import by.sadovnick.moboperator.dto.UserOperatorDto;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface providing methods for working with the user operator controller layer.
 */
public interface UserOperatorController extends MainController<UserOperator>, MainControllerDto<UserOperatorDto> {
    /**
     * Add tariff to user operator
     *
     * @param userOperatorId id of user operator
     * @param tariffId       id of tariff
     */
    void addTariffByIdToUserOperator(Long userOperatorId, Long tariffId);

    /**
     * Replenish balanse to user operator
     *
     * @param id    id of user operator
     * @param summa amount funds
     */
    void replenishTheBalanceById(@RequestParam Long id, @RequestParam Double summa);
}
