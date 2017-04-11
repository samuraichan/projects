package starter.data.entity;

import java.sql.Timestamp;
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
  
  @Column(name="my_date") // upon using java.sql.TimeStamp hibernate does not need you to define a @Temporal (since JDBC driver's mapping implictly handles this)
  private Timestamp timestamp;
  
  private Integer age;

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

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
