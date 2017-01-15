package starter.data.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import starter.data.model.RiskStatus;


@Entity
@Table(name = "risk_header")
public class RiskHeader extends BaseEntity {

  @Column(name="named_insured")
  private String namedInsured;
  
  @Column(name="status_id")
  private Integer statusId;
  
  @Column(name="active_flag")
  private String activeFlag;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "risk" /*, fetch=FetchType.EAGER */)
  private Collection<RiskBody> submissions;
  
  public RiskHeader() {}
  
  public RiskHeader(String name, RiskStatus status, boolean activeFlag) {
    this.namedInsured = name;
    this.statusId = status.getCode();
    if (activeFlag) {
      this.activeFlag = "Y";
    }
    else {
      this.activeFlag = "N";
    }
  }

  public String getNamedInsured() {
    return namedInsured;
  }

  public void setNamedInsured(String namedInsured) {
    this.namedInsured = namedInsured;
  }

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

  public Collection<RiskBody> getSubmissions() {
    return submissions;
  }

  public void setSubmissions(Collection<RiskBody> submissions) {
    this.submissions = submissions;
  }
}
