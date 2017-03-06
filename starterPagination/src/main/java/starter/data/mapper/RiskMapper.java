package starter.data.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import starter.data.model.DataTablesOutput;
import starter.data.model.PaginationParams;
import starter.data.model.Risk;
import starter.data.model.SearchFilter;

@Repository
public interface RiskMapper {
  
  public List<Risk> findAll();
  
  public List<Risk> findAllBySearchFilter(SearchFilter searchFilter);
  
  public List<Risk> findAllByPaginationParams(PaginationParams paginationParams);
  
  public DataTablesOutput findDataTablesOutputByPaginationParams(PaginationParams paginationParams);
}
