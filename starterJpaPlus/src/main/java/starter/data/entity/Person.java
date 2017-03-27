package starter.data.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@Entity
@Table(name="person")
@Audited
@AuditOverride(forClass = BaseEntity.class, isAudited = true)
@Where(clause="active_flag = 'Y'")
public class Person extends BaseEntity {
  
  public Person(){}
  
  public Person(String firstName, String lastName, Collection<Address> addresses, Boolean activeFlag) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.addresses = addresses;
    setActiveFlag(activeFlag);
  }

  @Column(name="first_name")
  private String firstName;
  
  @Column(name="last_name")
  private String lastName;

  @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="person")
  @Where(clause="active_flag = 'Y'")
  private Collection<Address> addresses;
  
  @Transient
//  @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//  @JoinTable(name="phone_number_owner",
//    joinColumns = @JoinColumn(name="owner_id"),
//    inverseJoinColumns = @JoinColumn(name="phone_number_id")
//  )
  //@WhereJoinTable(clause="active_flag = 'Y'")
  private List<PhoneNumber> phoneNumbers;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  
  public Collection<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Collection<Address> addresses) {
    this.addresses = addresses;
  }

  //@Where(clause="active_flag = 'Y'")
  public List<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }
}
