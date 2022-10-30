package by.sadovnick.moboperator.dao.entity;

import by.sadovnick.moboperator.dao.entity.parent.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * Class describing the entity of the client.
 */
@Data
@Entity
@Table
public class Client extends BaseEntity {

  @Column(name = "SURNAME", length = 10)
  private String surName;
}
