package starter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starter.data.entity.Book;
import starter.data.mapper.RiskMapper;
import starter.repository.BookRepository;

@Controller
public class GreetingController {
  
  @Autowired
  private RiskMapper riskMapper;
  
  @Autowired
  private BookRepository bookRepository;
  
  
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

}