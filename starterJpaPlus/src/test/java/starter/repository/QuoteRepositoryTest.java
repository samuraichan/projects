package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Quote;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class QuoteRepositoryTest {

  @Autowired
  private QuoteRepository quoteRepository;
   
  @Test
  public void testNotEmpty() {
    
    Collection<Quote> quotes = quoteRepository.findAll();
    assertThat(quotes).isNotEmpty();
    
    quotes.stream().forEach((q)-> assertThat(q.getPremium()).isNotNull());
  }
  
  @Test
  public void testManyToOneSubmission() {
    Quote quote = quoteRepository.findOne(700);
    assertThat(quote.getId()).isNotNull();
    
    assertThat(quote.getSubmission().getId()).isEqualTo(502);
  }
}
