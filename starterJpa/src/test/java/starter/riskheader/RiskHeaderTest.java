package starter.riskheader;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.RiskHeader;
import starter.data.model.RiskStatus;
import starter.repository.RiskHeaderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RiskHeaderTest {
  
  @Autowired
  private TestRestTemplate restTemplate;

  @MockBean
  private RiskHeaderRepository riskHeaderRepository;

  @Before
  public void setup() {
    
  }
  
  @Test
  public void test() {
    Assert.assertTrue(this.restTemplate.getForEntity(
      "/greeting", String.class, "??").getStatusCode().is2xxSuccessful());
  }
  
  @Test
  public void insert() {
    riskHeaderRepository.save(new RiskHeader("my first one", RiskStatus.COMPLETED, true));
  }
}
