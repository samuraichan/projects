package starter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starter.data.mapper.RiskMapper;

@Controller
public class GreetingController {
  
  @Autowired
  private RiskMapper riskMapper;
  
  
  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("risks", riskMapper.findAll());
    return "greetings";
  }

}