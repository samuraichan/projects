package starter.submissions;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Quote;
import starter.data.entity.RiskBody;
import starter.data.entity.RiskHeader;
import starter.data.model.RiskStatus;
import starter.data.model.SubmissionStatus;
import starter.repository.RiskHeaderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class SubmissionTest {
  
  @Autowired
  private RiskHeaderRepository riskHeaderRepository;
  
  
  @Before
  public void setup() {
    
  }
  
  @Test
  public void testActiveOnlyRecords() {
    RiskHeader risk = riskHeaderRepository.findByNamedInsured("one");
    assertThat(risk.getSubmissions()).isNotEmpty();
    
    risk.setStatus(RiskStatus.INPROGRESS);
    
    for (RiskBody submission : risk.getSubmissions()) {
      submission.setStatus(SubmissionStatus.DRAFT);
      Quote quote = new Quote(new BigDecimal("100.10"), true);
      quote.setSubmission(submission); // is this really the best approach ???
      submission.addQuote(quote);
    }
    
    riskHeaderRepository.save(risk);
  }
  
}
