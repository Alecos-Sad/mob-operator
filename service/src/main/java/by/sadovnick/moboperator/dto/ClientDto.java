package by.sadovnick.moboperator.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Dto for Client class
 * @see by.sadovnick.moboperator.dao.entity.Client
 */
@Data
@Setter
@Getter
public class ClientDto implements Serializable {

    private Long id;
    private String name;
    private String surName;
}
