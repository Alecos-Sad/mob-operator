package by.sadovnick.moboperator.dao.entity.parent;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class describing id and version of entity.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Version
  @Column(name = "version")
  private Long version;
}
