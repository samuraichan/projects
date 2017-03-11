package starter.data.multinational.data;

public class Detail {
  
  private Integer riskId;

  private String namedInsured;
  
  private String xmlDocument;
  
  private Document document;

  public Integer getRiskId() {
    return riskId;
  }

  public void setRiskId(Integer riskId) {
    this.riskId = riskId;
  }

  public String getNamedInsured() {
    return namedInsured;
  }

  public void setNamedInsured(String namedInsured) {
    this.namedInsured = namedInsured;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public String getXmlDocument() {
    return xmlDocument;
  }

  public void setXmlDocument(String xmlDocument) {
    this.xmlDocument = xmlDocument;
  }
}
