package starter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MultinationalController {

  @RequestMapping(value = "/input", method = RequestMethod.GET)
  public String get(Object model) {
    return "MultinationalInput";
  }
}
