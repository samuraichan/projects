package starter.data.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum RiskStatus {
  DRAFT(100), INPROGRESS(101), COMPLETED(104);

  private static final Map<Integer, RiskStatus> lookup = new HashMap<Integer, RiskStatus>();

  static {
    for (RiskStatus s : EnumSet.allOf(RiskStatus.class))
      lookup.put(s.getCode(), s);
  }

  private int code;

  private RiskStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static RiskStatus get(int code) {
    return lookup.get(code);
  }
}
