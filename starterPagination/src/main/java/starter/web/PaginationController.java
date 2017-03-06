package starter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import starter.data.mapper.RiskMapper;
import starter.data.model.DataTablesOutput;

@RestController
public class PaginationController {

  @Autowired
  private RiskMapper riskMapper;
  
  @RequestMapping(value = "/pagination", method = RequestMethod.POST)
  public DataTablesOutput findPagination(Object formObject, BindingResult bindingResult) {
    DataTablesOutput ouput = new DataTablesOutput();
    ouput.setData(riskMapper.findAll());
    return ouput;
  }
}
