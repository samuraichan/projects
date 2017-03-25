package starter.types;

public enum AccountHolderType {
  
  PRIMARY(1, "Primary"), Secondary(2, "Secondary");

  private AccountHolderType(int value, String label) {
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

  public static AccountHolderType valueOf(int phoneNumberType) {
    for (AccountHolderType type : values()) {
      if (type.value == phoneNumberType) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ phoneNumberType + "]");
  }
}
