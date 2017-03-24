package starter.data.mapper;

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
public class MultinationalMapperTest {
  
  @Autowired
  private MultinationalMapper mapper;
  
  @Test
  public void testDetailNotNull() {
    Detail detail = mapper.findDetailByRisk(2);
    assertThat(detail).isNotNull();
    assertThat(detail.getXmlDocument()).isNotEmpty();
  }
  
  
}
