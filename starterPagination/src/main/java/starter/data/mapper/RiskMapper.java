package starter.data.mapper;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import starter.data.model.Risk;
import starter.data.model.SearchFilter;

@Repository
public interface RiskMapper {
  
  public Collection<Risk> findAll();
  
  public Collection<Risk> findAllBySearchFilter(SearchFilter searchFilter);
}
