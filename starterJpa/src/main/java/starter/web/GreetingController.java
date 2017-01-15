package starter.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starter.data.entity.Book;
import starter.data.entity.RiskBody;
import starter.data.entity.RiskHeader;
import starter.data.mapper.RiskMapper;
import starter.repository.BookRepository;
import starter.repository.RiskHeaderRepository;

@Controller
public class GreetingController {
  
  @Autowired
  private RiskMapper riskMapper;
  
  @Autowired
  private BookRepository bookRepository;
  
  @Autowired
  private RiskHeaderRepository riskHeaderRepository;
  
  
  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("risks", riskMapper.findAll());
    return "greetings";
  }
  
  @RequestMapping("/rev")
  public String rev(Model model) throws InterruptedException {
    Book book = bookRepository.save(new Book("Douglas Preston", "The Lost City of God", "1455540005"));
    book.setTitle("The Lost City of Gods");
    bookRepository.save(book);
    Thread.sleep(2000);
    bookRepository.delete(book);
    return "greetings";
  }
  
  @RequestMapping("/lazy")
  public String lazyLoad(Model model) throws InterruptedException {
    RiskHeader risk = riskHeaderRepository.findById(1);
   
    for (RiskBody riskBody : risk.getSubmissions()) {
      System.out.println(riskBody.getStatusId());
    }
    return "greetings";
  }

}