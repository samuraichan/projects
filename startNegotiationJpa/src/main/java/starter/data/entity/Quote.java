package starter.data.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "quote")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
public class Quote extends BaseEntity {
  
  public Quote() {}
  
  public Quote(BigDecimal premium, boolean activeFlag) {
    setPremium(premium);
    setActiveFlag(activeFlag);
  }

  @ManyToOne
  @JoinColumn(name = "risk_body_id")
  private RiskBody submission;
  
  @Column(name = "net_premium")
  private BigDecimal premium;

  public RiskBody getSubmission() {
    return submission;
  }

  public void setSubmission(RiskBody submission) {
    this.submission = submission;
  }

  public BigDecimal getPremium() {
    return premium;
  }

  public void setPremium(BigDecimal premium) {
    this.premium = premium;
  }
}
