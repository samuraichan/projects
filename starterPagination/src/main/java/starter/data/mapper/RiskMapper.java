package starter.data.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;
import starter.data.model.Risk;
import starter.data.model.SearchFilter;

@Repository
public interface RiskMapper {
  
  public List<Risk> findAll();
  
  public List<Risk> findAllBySearchFilter(SearchFilter searchFilter);
   
  public DataTablesOutput findDataTablesOutput(DataTablesInput input);
  
  public Integer findRecordCount(DataTablesInput input);
}
