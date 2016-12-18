package starter.riskheader;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.RiskHeader;
import starter.data.model.RiskStatus;
import starter.repository.RiskHeaderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RiskHeaderTest {
  
  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private RiskHeaderRepository riskHeaderRepository;

  @Before
  public void setup() {
    
  }
  
  @Test
  public void test() {
    assertThat(this.restTemplate.getForEntity(
      "/greeting", String.class, "??").getStatusCode()).isEqualTo(HttpStatus.OK);
  }
  
  @Test
  public void insert() {
    RiskHeader risk = new RiskHeader("my first one", RiskStatus.COMPLETED, true);
    assertThat(risk.getId()).isNull();
    
    risk = riskHeaderRepository.save(risk);
    assertThat(risk.getId()).isNotNull();
    
    risk = riskHeaderRepository.findByNamedInsured("my first one");
    
    assertThat(risk).isNotNull();
    assertThat(risk.getStatusId()).isEqualTo(RiskStatus.COMPLETED.getCode());
  }
}
