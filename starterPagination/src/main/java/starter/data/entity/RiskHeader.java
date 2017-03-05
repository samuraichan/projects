package starter.data.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.data.model.RiskStatus;


@Entity
@Table(name = "risk_header")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
public class RiskHeader extends BaseEntity {

  @Column(name="named_insured")
  private String namedInsured;
  
  @Column(name="status_id")
  private Integer status;
  
  public RiskHeader() {}
  
  public RiskHeader(String name, RiskStatus status, boolean activeFlag) {
    this.namedInsured = name;
    this.status = status.getCode();
    setActiveFlag(activeFlag);
  }

  public String getNamedInsured() {
    return namedInsured;
  }

  public void setNamedInsured(String namedInsured) {
    this.namedInsured = namedInsured;
  }

  public RiskStatus getStatus() {
    return RiskStatus.get(status);
  }

  public void setStatus(RiskStatus status) {
    if (status == null) {
      this.status = null;
    }
    else {
      this.status = status.getCode();
    }
  }
}
