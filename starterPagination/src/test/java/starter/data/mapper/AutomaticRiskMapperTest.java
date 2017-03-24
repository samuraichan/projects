package starter.data.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class AutomaticRiskMapperTest {

  @Autowired
  private AutomaticRiskMapper automaticRiskMapper;
  
  @Test
  public void testIsNotEmpty() {
    assertThat(automaticRiskMapper.findAll()).isNotEmpty();
  }
}
