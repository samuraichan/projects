package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "risk_body")
public class RiskBody extends BaseEntity {
 
  @Column(name="status_id")
  private Integer statusId;
  
  @Column(name="active_flag")
  private String activeFlag;
  
  @ManyToOne
  @JoinColumn(name = "risk_header_id")
  private RiskHeader risk;

  public Integer getStatusId() {
    return statusId;
  }

  public void setStatusId(Integer statusId) {
    this.statusId = statusId;
  }

  public String getActiveFlag() {
    return activeFlag;
  }

  public void setActiveFlag(String activeFlag) {
    this.activeFlag = activeFlag;
  }

  public RiskHeader getRisk() {
    return risk;
  }

  public void setRisk(RiskHeader risk) {
    this.risk = risk;
  }
}
