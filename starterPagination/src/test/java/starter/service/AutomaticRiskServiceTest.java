package starter.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class AutomaticRiskServiceTest {

  @Autowired
  private AutomaticRiskService automaticRiskService;
  
  
  @Test
  public void testCollectionIsNotEmpty() {
    assertThat(automaticRiskService.findAll()).isNotEmpty();
  }
  
  @Test
  public void testAutomaticRiskIsNotNull() {
    assertThat(automaticRiskService.findByRiskId(1)).isNotNull();
  }
  
  @Test
  public void testAutomaticRiskXMLIsNotNull() {
    assertThat(automaticRiskService.findByRiskId(1).getXml()).isNotNull();
  }
  
  @Test
  public void testXMLDataIsNotNull() throws Exception {
    assertThat(automaticRiskService.findDataByRiskId(1)).isNotNull();
  }
}
