package starter.types;


public enum StatusType {

  DRAFT(100, "Draft Submission"), IN_PROGRESS(101, "In Progress"), NEEDS_QUOTE(204, "Needs Quote"), QUOTED(303, "Quoted"), ORIGINAL_SUBMISSION(1201, "Original Submission"), DRAFT_SUBMISSION(1200, "Submission Draft");

  private StatusType(Integer value, String label) {
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

  public static StatusType valueOf(Integer statusId) {
    if (statusId == null) {
      return null;
    }
    
    for (StatusType type : values()) {
      if (type.value.equals(statusId)) {
        return type;
      }
    }
    throw new IllegalArgumentException("No matching constant for ["+ statusId + "]");
  }
}
