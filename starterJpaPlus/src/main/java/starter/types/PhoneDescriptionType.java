package starter.types;


public enum PhoneDescriptionType {

  MOBILE("Mobile"), OFFICE("Office"), HOME("Home");

  private PhoneDescriptionType(String label) {
    this.label = label;
  }

  private final String label;

  public String getLabel() {
    return label;
  }
  
  public static PhoneDescriptionType labelOf(String label) {
    if (label == null) {
      return null;
    }
    
    for (PhoneDescriptionType type : values()) {
      if (type.label.equals(label)) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ label + "]");
  }
}