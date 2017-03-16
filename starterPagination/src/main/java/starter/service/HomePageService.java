package starter.service;

import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;
import starter.data.model.PaginationParams;

public interface HomePageService {

  public DataTablesOutput findDataTablesOutputByPaginationParams(PaginationParams paginationParams);
  
  public DataTablesOutput findDataTablesOutput(DataTablesInput input);
  
}
