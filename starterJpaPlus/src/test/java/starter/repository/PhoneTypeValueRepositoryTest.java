package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.PhoneTypeValue;
import starter.types.PhoneValueType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class PhoneTypeValueRepositoryTest {

  @Autowired
  private PhoneTypeValueRepository phoneValueTypeRepository;
    
  @Test
  public void testJpaConverter() {
    PhoneTypeValue phone = new PhoneTypeValue();
    phone.setActiveFlag(true);
    phone.setType(PhoneValueType.OFFICE);
    phoneValueTypeRepository.save(phone);
    
    assertThat(phoneValueTypeRepository.findAllByType(PhoneValueType.OFFICE)).isNotEmpty();
  }
}
