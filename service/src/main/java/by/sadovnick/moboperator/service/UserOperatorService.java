package by.sadovnick.moboperator.service;

import by.sadovnick.moboperator.dao.entity.UserOperator;
import by.sadovnick.moboperator.dto.UserOperatorDto;

/**
 * Interface providing methods for working with the user operator service layer.
 */
public interface UserOperatorService extends MainService<UserOperator>, MainServiceDto<UserOperatorDto> {
    /**
     * Adding tarif to user operator
     *
     * @param userOperatorId id of user operator
     * @param tariffId       id of tariff
     */
    void addTariffByIdToUserOperator(Long userOperatorId, Long tariffId);

    /**
     * Adding funs to the balance
     *
     * @param id    id of user operator
     * @param summa amount of funds
     */
    void replenishTheBalanceById(Long id, Double summa);

    /**
     * Getting status from external microservice
     *
     * @param status status request
     * @return request
     */
    String getStatus(String status);
}
