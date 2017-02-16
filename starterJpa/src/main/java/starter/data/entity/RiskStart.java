package starter.data.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class RiskStart {

  @NotEmpty(message="We need a first name please")
  private String firstName;
  
  @NotEmpty(message="Please Don't forget you last name as well")
  private String lastName;

  
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
  
  
}
