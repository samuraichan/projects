package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Quote;
import starter.data.entity.Submission;
import starter.types.StatusType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class SubmissionRepositoryTest {

  @Autowired
  private SubmissionRepository submissionRepository;
   
  @Test
  public void testOneToMany() {
    assertThat(submissionRepository.findOne(502).getQuotes().isEmpty()).isFalse();
    assertThat(submissionRepository.findOne(502).getQuotes().stream().findFirst().map(Quote::getPremium).orElse(BigDecimal.ZERO)).isEqualTo(new BigDecimal("100.12"));
    assertThat(submissionRepository.findOne(500).getQuotes().stream().findFirst().map(Quote::getPremium).orElse(BigDecimal.ZERO)).isEqualTo(BigDecimal.ZERO);
  }
  
  @Test
  public void test_submission_status_types() {
    assertThat(submissionRepository.findOne(502).getStatus()).isEqualTo(StatusType.NEEDS_QUOTE);
  }
  
  @Test
  public void test_submission_insert_no_quotes() {
    
    int count = submissionRepository.findAll().size();
    
    Submission sub = new Submission();
    sub.setActiveFlag(true);
    sub.setStatus(StatusType.DRAFT);
    submissionRepository.save(sub);
    
    assertThat(submissionRepository.findAll().size()).isEqualTo(count+1);
  }
  
  @Test
  public void test_submission_insert_no_quotes_where_active() {
    
    int count = submissionRepository.findAll().size();
    
    Submission sub = new Submission();
    sub.setStatus(StatusType.DRAFT);
    submissionRepository.save(sub);
    
    // since we did not set active flag, it's false; thus the @WHERE condition does not return non-active
    assertThat(submissionRepository.findAll().size()).isEqualTo(count);
  }
  
  @Test
  public void test_submission_single_quote() {
    Submission sub = new Submission();
    sub.setActiveFlag(true);
    sub.setStatus(StatusType.DRAFT);
    
    Quote quote = new Quote();
    quote.setActiveFlag(true);
    quote.setPremium(BigDecimal.ONE);
    sub.addQuote(quote);
    
    sub = submissionRepository.save(sub);
    Optional<Quote> savedQuote = sub.getQuotes().stream().findFirst();
    assertThat(savedQuote.map((q) -> q.getId()).isPresent()).isTrue();
  }
  
  @Test
  public void test_submission_created_and_updated_dates() {
    Submission sub = submissionRepository.findOne(501);
    assertThat(sub.getCreatedDate().equals(sub.getUpdatedDate())).isTrue();
    
    sub.setStatus(StatusType.IN_PROGRESS);
    sub = submissionRepository.save(sub);
    assertThat(sub.getCreatedDate().equals(sub.getUpdatedDate())).isFalse();
    assertThat(sub.getUpdatedDate().compareTo(sub.getCreatedDate()) > 0).isTrue();
  }
  
  @Test
  public void test_submission_remove_quote() {
    Submission sub = submissionRepository.findOne(502);
    
    assertThat(sub.getCreatedDate().equals(sub.getUpdatedDate())).isTrue();
    
    Collection<Quote> quotesToRemove = sub.getQuotes().stream().filter((q) -> q.getPremium().compareTo(new BigDecimal("1000")) > 0).collect(Collectors.toList());
    for (Quote quote : quotesToRemove) {
      sub.removeQuote(quote);
    }
    
    sub = submissionRepository.save(sub);
    assertThat(submissionRepository.findOne(502).getQuotes().size()).isEqualTo(1);
    assertThat(sub.getCreatedDate().equals(sub.getUpdatedDate())).isTrue();
    
    sub.setStatus(StatusType.QUOTED);
    sub = submissionRepository.save(sub);
    assertThat(sub.getUpdatedDate().compareTo(sub.getCreatedDate()) > 0).isTrue();
  }
}
