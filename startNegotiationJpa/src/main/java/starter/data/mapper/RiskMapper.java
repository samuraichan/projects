package starter.data.mapper;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import starter.data.model.Risk;

@Repository
public interface RiskMapper {
  
  public Collection<Risk> findAll();
}
