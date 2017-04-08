package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.types.PhoneDescriptionType;

@Entity
@Table(name="phone_type")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
@Where(clause="active_flag = 'Y'")
public class PhoneTypeDescription extends BaseEntity {
  
  @Enumerated(EnumType.STRING)
  @Column(name="description")
  private PhoneDescriptionType type;

  public PhoneDescriptionType getType() {
    return type;
  }

  public void setType(PhoneDescriptionType type) {
    this.type = type;
  } 
}
