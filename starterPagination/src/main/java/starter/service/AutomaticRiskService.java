package starter.service;

import java.util.Collection;

import starter.data.model.AutomaticRisk;
import starter.data.model.Data;

public interface AutomaticRiskService {

  public Collection<AutomaticRisk> findAll();
  
  public AutomaticRisk findByRiskId(Integer riskId);
  
  public Data findDataByRiskId(Integer riskId) throws Exception;
}
