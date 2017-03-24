package starter.data.multinational.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Data")
public class Document {

  @JacksonXmlProperty(localName = "Coverage")
  private Coverage coverage;
  

  public Coverage getCoverage() {
    return coverage;
  }

  public void setCoverage(Coverage coverage) {
    this.coverage = coverage;
  }
}
