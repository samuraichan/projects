package starter.data.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.data.model.MailingAddress;

@Entity
@Table(name="contact")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
@Where(clause="active_flag = 'Y'")
public class Contact extends BaseEntity {
 
  @Embedded
  private MailingAddress mailingAddress;

  public MailingAddress getMailingAddress() {
    return mailingAddress;
  }

  public void setMailingAddress(MailingAddress mailingAddress) {
    this.mailingAddress = mailingAddress;
  }
}
