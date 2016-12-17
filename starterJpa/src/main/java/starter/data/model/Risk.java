package starter.data.model;

public class Risk {

  private Long riskHeaderId;
  
  private Long versionNumber;
  
  private String namedInsured;
  
  private RiskStatus status;

  public Long getRiskHeaderId() {
    return riskHeaderId;
  }

  public void setRiskHeaderId(Long riskHeaderId) {
    this.riskHeaderId = riskHeaderId;
  }

  public Long getVersionNumber() {
    return versionNumber;
  }

  public void setVersionNumber(Long versionNumber) {
    this.versionNumber = versionNumber;
  }

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
