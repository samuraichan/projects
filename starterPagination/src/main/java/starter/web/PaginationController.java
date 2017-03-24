package starter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;
import starter.service.HomePageService;

@RestController
public class PaginationController {

  @Autowired
  private HomePageService homePageService;
  
  @RequestMapping(value = "/pagination", method = RequestMethod.POST)
  public DataTablesOutput findPagination(DataTablesInput input, BindingResult bindingResult) {
    return homePageService.findDataTablesOutput(input);
  }
}
