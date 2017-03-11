package starter.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.multinational.data.Detail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class MultinationalServiceTest {

  @Autowired
  private MultinatinalService multinationalService;
  
  @Test
  public void MultinationalDetailIsNotEmptyTest() {
    Detail detail = multinationalService.findDetailByRisk(2);
    assertThat(detail.getNamedInsured()).isNotNull();
    assertThat(detail.getDocument()).isNotNull();
  }
}
