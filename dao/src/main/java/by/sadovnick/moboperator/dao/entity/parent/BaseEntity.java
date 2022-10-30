package by.sadovnick.moboperator.dao.entity.parent;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class describing name of entity.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity extends AbstractEntity {

  @Basic
  @Column(name = "NAME", columnDefinition = "VARCHAR(100)")
  private String name;
}
