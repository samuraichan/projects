package starter.types;


public enum MarketClassType {

  PROPERTY(1, "Property"), 
  CASUALTY(2, "Casualty"), 
  EXCESS_OF_LOSS(3, "Excess of Loss"), 
  SURPLUS_SHARE(4, "Surplus Share"),
  VARIABLE_QUOTE(5, "Variable Quote");

  private MarketClassType(Integer value, String label) {
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

  public static MarketClassType valueOf(Integer marketClassType) {
    if (marketClassType == null) {
      return null;
    }
    
    for (MarketClassType type : values()) {
      if (type.value == marketClassType) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ marketClassType + "]");
  }
}
