package starter.data.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Risk {
  
  private String namedInsured;
  
  private RiskStatus status;
  
  private Date createdDate;
  
  public String getNamedInsured() {
    return namedInsured;
  }

  public void setNamedInsured(String namedInsured) {
    this.namedInsured = namedInsured;
  }

  public RiskStatus getStatus() {
    return status;
  }

  public void setStatus(RiskStatus status) {
    this.status = status;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public String getCreatedDateString() {
    SimpleDateFormat format1 = new SimpleDateFormat("dd MMMMM yyyy");
    return format1.format(createdDate);
  }
}
