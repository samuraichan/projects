package starter.data.entity;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.OptionalInt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

@Entity
@Where(clause="active_flag = 'Y'")
public class Quote extends BaseEntity {
  
  @ManyToOne
  private Submission submission;
  
  @Column(name="net_premium")
  private BigDecimal premium;

  public Submission getSubmission() {
    return submission;
  }

  public void setSubmission(Submission submission) {
    this.submission = submission;
  }

  public BigDecimal getPremium() {
    return premium;
  }

  public void setPremium(BigDecimal premium) {
    this.premium = premium;
  }
  
  
}
