package starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import starter.data.mapper.RiskMapper;
import starter.data.model.DataTablesOutput;
import starter.data.model.PaginationParams;
import starter.service.HomePageService;

@Service
public class DefaultHomePageService implements HomePageService {

  private final RiskMapper riskMapper;
  
  @Autowired
  public DefaultHomePageService(RiskMapper riskMapper) {
    this.riskMapper = riskMapper;
  }

  @Override
  public DataTablesOutput findDataTablesOutputByPaginationParams(PaginationParams paginationParams) {
    DataTablesOutput output = riskMapper.findDataTablesOutputByPaginationParams(paginationParams);
    if (output == null) {
      output = new DataTablesOutput();
    }
    else {
      output.setRecordsFiltered(output.getResultSize());
    }
    
    return output;
  }
  
  
}
