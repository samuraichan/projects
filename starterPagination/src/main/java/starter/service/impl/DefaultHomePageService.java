package starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import starter.data.mapper.RiskMapper;
import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;
import starter.service.HomePageService;

@Service
public class DefaultHomePageService implements HomePageService {

  private final RiskMapper riskMapper;
  
  @Autowired
  public DefaultHomePageService(RiskMapper riskMapper) {
    this.riskMapper = riskMapper;
  }

  @Override
  public DataTablesOutput findDataTablesOutput(DataTablesInput input) {
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    if (output == null) {
      output = new DataTablesOutput();
      output.setRecordsTotal(riskMapper.findRecordCount(input));
    }
    
    return output;
  }
}
