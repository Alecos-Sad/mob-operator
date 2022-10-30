package by.sadovnick.moboperator.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Dto for Tariff class
 * @see by.sadovnick.moboperator.dao.entity.Tariff
 */
@Data
public class TariffDto implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private Double subscriptionFee;
    private Integer freeMinutes;
}
