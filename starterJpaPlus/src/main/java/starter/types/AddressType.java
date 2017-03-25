package starter.types;

public enum AddressType {
  MAILING(1, "Mailing"), HOME(2, "Home"), BUSINESS(3, "Business");

  private AddressType(int value, String label) {
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

  public static AddressType valueOf(int phoneNumberType) {
    for (AddressType type : values()) {
      if (type.value == phoneNumberType) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ phoneNumberType + "]");
  }
}
