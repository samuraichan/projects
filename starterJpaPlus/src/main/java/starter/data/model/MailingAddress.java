package starter.data.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MailingAddress {

  private String street;
  
  private String city;
  
  @Column(name="postal_codee")
  private String postalCode;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
}

