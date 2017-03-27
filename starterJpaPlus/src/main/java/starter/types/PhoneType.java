package starter.types;


public enum PhoneType {

  MOBILE(1, "Mobile"), OFFICE(2, "Office"), HOME(3, "Home");

  private PhoneType(Integer value, String label) {
    this.value = value;
    this.label = label;
  }

  private final Integer value;
  private final String label;

  public Integer getValue() {
    return value;
  }

  public String getLabel() {
    return label;
  }

  public static PhoneType valueOf(Integer phoneNumberType) {
    if (phoneNumberType == null) {
      return null;
    }
    
    for (PhoneType type : values()) {
      if (type.value == phoneNumberType) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ phoneNumberType + "]");
  }
}
