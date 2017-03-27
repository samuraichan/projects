package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.types.PhoneType;

@Entity
@Table(name="phone_number")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
@Where(clause="active_flag = 'Y'")
public class PhoneNumber extends BaseEntity {

  @Column(name="type")
  private Integer phoneType;
  
  @Column
  private String number;

  public PhoneType getType() {
    return PhoneType.valueOf(phoneType);
  }

  public void setType(PhoneType type) {
    if (type == null) {
      phoneType = null;
    }
    else {
      phoneType = type.getValue();
    }
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
