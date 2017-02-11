package starter.data.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.data.model.SubmissionStatus;


@Entity
@Table(name = "risk_body")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
public class RiskBody extends BaseEntity {
 
  @Column(name="status_id")
  private Integer status;
  
  @ManyToOne
  @JoinColumn(name = "risk_header_id")
  private RiskHeader risk;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "submission", fetch=FetchType.EAGER)
  private Collection<Quote> quotes;

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

  public Collection<Quote> getQuotes() {
    return quotes;
  }

  public void setQuotes(Collection<Quote> quotes) {
    this.quotes = quotes;
  }
  
  public void addQuote(Quote quote) {
    if (CollectionUtils.isEmpty(quotes)) {
      quotes = new ArrayList<Quote>();
    }
    quotes.add(quote);
  }
}
