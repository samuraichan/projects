package starter.types;


public enum PhoneValueType {

  MOBILE(33), OFFICE(90), HOME(100);

  private PhoneValueType(Integer value) {
    this.value = value;
  }

  private final Integer value;

  public Integer getValue() {
    return value;
  }

  public static PhoneValueType valueOf(Integer phoneNumberType) {
    if (phoneNumberType == null) {
      return null;
    }
    
    for (PhoneValueType type : values()) {
      if (type.value == phoneNumberType) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ phoneNumberType + "]");
  }
}
