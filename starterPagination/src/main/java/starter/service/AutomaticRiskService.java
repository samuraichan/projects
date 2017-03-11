package starter.service;

import java.util.Collection;

import starter.data.model.AutomaticRisk;
import starter.data.multinational.data.MultinationalDocument;

public interface AutomaticRiskService {

  public Collection<AutomaticRisk> findAll();
  
  public AutomaticRisk findByRiskId(Integer riskId);
  
  public MultinationalDocument findMultinationalDocumentByRiskId(Integer riskId) throws Exception;
}
