package starter.data.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SubmissionStatus {
  DRAFT(1200), ORIGINAL(1201), QUOTE(204);

  private static final Map<Integer, SubmissionStatus> lookup = new HashMap<Integer, SubmissionStatus>();

  static {
    for (SubmissionStatus s : EnumSet.allOf(SubmissionStatus.class))
      lookup.put(s.getCode(), s);
  }

  private int code;

  private SubmissionStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static SubmissionStatus get(int code) {
    return lookup.get(code);
  }
}
