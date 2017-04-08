package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.data.entiy.converter.PhoneValueTypeConverter;
import starter.types.PhoneValueType;

@Entity
@Table(name="phone_value")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
@Where(clause="active_flag = 'Y'")
public class PhoneTypeValue extends BaseEntity {
  
  @Convert(converter=PhoneValueTypeConverter.class)
  @Column(name="value")
  private PhoneValueType type;

  public PhoneValueType getType() {
    return type;
  }

  public void setType(PhoneValueType type) {
    this.type = type;
  }
}
