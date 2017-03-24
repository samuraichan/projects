package starter.data.mapper;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import starter.data.model.AutomaticRisk;

@Repository
public interface AutomaticRiskMapper {

  public Collection<AutomaticRisk> findAll();
  
  public AutomaticRisk findByRiskId(Integer riskId);
}
