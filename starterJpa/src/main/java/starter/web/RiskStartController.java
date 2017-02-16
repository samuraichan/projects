package starter.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import starter.data.entity.RiskStart;
import starter.data.mapper.RiskMapper;

@Controller
public class RiskStartController {

  @Autowired
  private RiskMapper riskMapper;
  
  
  @RequestMapping(value = "/riskstart", method = RequestMethod.GET)
  public String get(Model model) {
    model.addAttribute("risks", riskMapper.findAll());
    if (!model.containsAttribute("riskStart")) {
      model.addAttribute("riskStart", new RiskStart());
    }
    return "riskStart";
  }
  
  @RequestMapping(value = "/riskstart/save", method = RequestMethod.POST)
  public String post(@Valid RiskStart riskStart, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
    if (bindingResult.hasErrors()) {
      redirectAttrs.addFlashAttribute("riskStart", riskStart);
      redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.riskStart", bindingResult);
      return "redirect:/riskstart";
    }
    
    return "redirect:/greeting";
  }
}
