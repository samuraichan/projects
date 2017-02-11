package starter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starter.data.entity.RiskHeader;
import starter.data.mapper.RiskMapper;
import starter.data.model.RiskStatus;
import starter.repository.RiskHeaderRepository;

@Controller
public class GreetingController {
  
  @Autowired
  private RiskMapper riskMapper;
  
  @Autowired
  private RiskHeaderRepository repository;
  
  
  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    
    repository.save(new RiskHeader("Sample Policy", RiskStatus.COMPLETED, true));
    
    model.addAttribute("name", name);
    model.addAttribute("risks", riskMapper.findAll());
    return "greetings";
  }

}