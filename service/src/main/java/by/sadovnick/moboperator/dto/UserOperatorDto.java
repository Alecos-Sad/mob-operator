package by.sadovnick.moboperator.dto;

import by.sadovnick.moboperator.dao.entity.Client;
import by.sadovnick.moboperator.dao.entity.Tariff;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Dto for User operator class
 * @see by.sadovnick.moboperator.dao.entity.UserOperator
 */
@Data
public class UserOperatorDto implements Serializable {

    private Long id;
    private Client client;
    private List<Tariff> tariffs;
    private Double balance;
    private String number;
}
