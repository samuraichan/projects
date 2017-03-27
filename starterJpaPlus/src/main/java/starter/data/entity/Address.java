package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import starter.types.AddressType;

@Entity
@Table(name="address")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
@Where(clause="active_flag = 'Y'")
public class Address extends BaseEntity {
  
  public Address() {}
  
  public Address(String street, String state, String city, String zip, Person person, Boolean activeFlag) {
    this.street = street;
    this.state = state;
    this.city = city;
    this.zip = zip;
    this.person = person;
    setActiveFlag(activeFlag);
  }

  @Column(name="street")
  private String street;
  
  @Column(name="state")
  private String state;
  
  @Column(name="city")
  private String city;
  
  @Column(name="zip")
  private String zip;
  
  @Transient
  private AddressType addressType;
  
  @ManyToOne
  @JoinColumn(name="owner_id")
  private Person person;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public AddressType getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
