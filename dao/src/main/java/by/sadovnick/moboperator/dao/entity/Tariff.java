package by.sadovnick.moboperator.dao.entity;

import by.sadovnick.moboperator.dao.entity.parent.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * Class describing the entity of the tariff
 */
@Data
@Entity
@Table
public class Tariff extends BaseEntity implements Comparable<Tariff> {

  @Column(name = "PRICE", length = 5)
  private Double price;
  @Column(name = "SUBSCRIPTION_FEE", length = 5)
  private Double subscriptionFee;
  @Column(name = "FREE_MINUTES", length = 5)
  private Integer freeMinutes;

  @Override
  public int compareTo(Tariff tariff) {
    return (int) (subscriptionFee - tariff.subscriptionFee);
  }
}
