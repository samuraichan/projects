package starter.riskheader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.RiskHeader;
import starter.data.model.RiskStatus;
import starter.repository.RiskHeaderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RiskHeaderTest {
  
  private static final String NAMED_INSURED = "Insurance Policy NP-1120";
  
  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private RiskHeaderRepository riskHeaderRepository;

  @Before
  public void setup() {
    
  }
  
  @Test
  public void testHttpStatusOK() {
    assertThat(this.restTemplate.getForEntity(
      "/greeting", String.class, "??").getStatusCode()).isEqualTo(HttpStatus.OK);
  }
  
  @Test
  public void testRiskInsert() {
    RiskHeader risk = new RiskHeader(NAMED_INSURED, RiskStatus.COMPLETED, true);
    assertThat(risk.getId()).isNull();
    
    risk = riskHeaderRepository.save(risk);
    assertThat(risk.getId()).isNotNull();
  }
  
  @Test
  public void testVersionUpdate() {
    RiskHeader risk = riskHeaderRepository.findByNamedInsured("four");
    risk.setStatusId(RiskStatus.DRAFT.getCode()); // status id is now dirty
    int version = risk.getVersion();
    risk = riskHeaderRepository.save(risk);
    assertThat(riskHeaderRepository.save(risk).getVersion()).isEqualTo(version+1);
  }
  
  @Test
  public void testVersionNoUpdate() {
    RiskHeader risk = riskHeaderRepository.findByNamedInsured("four");
    int version = risk.getVersion();
    risk = riskHeaderRepository.save(risk); // risk is not dirty, no update occurs
    assertThat(riskHeaderRepository.save(risk).getVersion()).isEqualTo(version);
  }
  
  @Test
  public void testLockingException() {
    RiskHeader risk = riskHeaderRepository.findByNamedInsured(NAMED_INSURED);
    assertThat(risk.getNamedInsured()).isEqualTo(NAMED_INSURED);
    
    Throwable thrown = catchThrowable(new ThrowingCallable() {
      @Override
      public void call() throws Exception {
        RiskHeader risk = riskHeaderRepository.findByNamedInsured(NAMED_INSURED);
        risk.setVersion(risk.getVersion() - 1);
        riskHeaderRepository.save(risk);
      }
    });
    
    assertThat(thrown).isInstanceOf(ObjectOptimisticLockingFailureException.class);
  }
  
  @Test
  public void testActiveOnlyRecords() {
    Long records = riskHeaderRepository.count();
    riskHeaderRepository.save(new RiskHeader("My Man", RiskStatus.INPROGRESS, false));

    assertThat(riskHeaderRepository.count()).isEqualTo(records+1);
    assertThat(riskHeaderRepository.countByActive()).isEqualTo(records);
  }
}
