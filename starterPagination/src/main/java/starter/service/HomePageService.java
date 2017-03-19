package starter.service;

import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;

public interface HomePageService {
  
  public DataTablesOutput findDataTablesOutput(DataTablesInput input);
  
}
