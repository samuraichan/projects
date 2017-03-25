package starter.types;


public enum PhoneType {

  MOBILE(1, "Mobile"), OFFICE(2, "Office"), HOME(3, "Home");

  private PhoneType(int value, String label) {
    this.value = value;
    this.label = label;
  }

  private final int value;
  private final String label;

  public int getValue() {
    return value;
  }

  public String getLabel() {
    return label;
  }

  public static PhoneType valueOf(int phoneNumberType) {
    for (PhoneType type : values()) {
      if (type.value == phoneNumberType) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ phoneNumberType + "]");
  }
}
