package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import starter.data.model.SubmissionStatus;


@Entity
@Table(name = "risk_body")
@Audited
public class RiskBody extends BaseEntity {
 
  @Column(name="status_id")
  private Integer status;
  
  @ManyToOne
  @JoinColumn(name = "risk_header_id")
  private RiskHeader risk;

  public SubmissionStatus getStatus() {
    return SubmissionStatus.get(status);
  }

  public void setStatus(SubmissionStatus submissionStatus) {
    if (status == null) {
      this.status = null;
    }
    else {
      status = submissionStatus.getCode();
    }
  }

  public RiskHeader getRisk() {
    return risk;
  }

  public void setRisk(RiskHeader risk) {
    this.risk = risk;
  }
}
