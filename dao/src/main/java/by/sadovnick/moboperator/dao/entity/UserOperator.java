package by.sadovnick.moboperator.dao.entity;

import by.sadovnick.moboperator.dao.entity.parent.AbstractEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * Сlass describing the entity of the UserOperator
 *
 * @see Client
 * @see Tariff
 */
@Data
@Entity
@Table
public class UserOperator extends AbstractEntity {

  @OneToOne
  @JoinColumn(name = "client_id")
  private Client client;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tariff> tariffs;
  @Column(name = "operator_balance")
  private Double balance;
  @Column(name = "phone_number")
  private String number;
}

