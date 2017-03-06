package starter.data.model;

import java.util.Date;

public class Risk {
  
  private String namedInsured;
  
  private RiskStatus status;
  
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
}
