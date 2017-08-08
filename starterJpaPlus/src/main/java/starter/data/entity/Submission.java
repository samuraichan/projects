package starter.data.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import starter.types.StatusType;

@Entity
@Table(name="risk_body")
@Where(clause="active_flag = 'Y'")
public class Submission extends BaseEntity {
  
  @Column(name="risk_id")
  private Integer risk;
  
  @Column(name="status_id")
  private Integer status;
  
  @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
  private Collection<Quote> quotes = new ArrayList<>();
  
  public StatusType getStatus() {
    return StatusType.valueOf(status);
  }

  public void setStatus(StatusType type) {
    if (type == null) {
      status = null;
    }
    else {
      status = type.getValue();
    }
  }
  
  public void addQuote(Quote quote) {
    quotes.add(quote);
    quote.setSubmission(this);
  }
  
  public void removeQuote(Quote quote) {
    quote.setSubmission(null);
    quotes.remove(quote);
  }

  public Integer getRisk() {
    return risk;
  }

  public void setRisk(Integer risk) {
    this.risk = risk;
  }

  public Collection<Quote> getQuotes() {
    return quotes;
  }

  public void setQuotes(Collection<Quote> quotes) {
    this.quotes = quotes;
  }
}
