package starter.data.multinational.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Type {
  
  @JacksonXmlProperty(localName = "Name")
  private String name;
  
  public Type() {
    
  }
  
  public Type(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
