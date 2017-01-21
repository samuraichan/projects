package starter.submissions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.RiskHeader;
import starter.repository.RiskHeaderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
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
  }
  
}
