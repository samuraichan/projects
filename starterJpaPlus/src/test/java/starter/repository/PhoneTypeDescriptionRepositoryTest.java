package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.PhoneTypeDescription;
import starter.types.PhoneDescriptionType;
;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class PhoneTypeDescriptionRepositoryTest {

  @Autowired
  private PhoneTypeDescriptionRepository phoneTypeRepository;
    
  @Test
  public void testJpaEnumerated() {
    PhoneTypeDescription phone = new PhoneTypeDescription();
    phone.setActiveFlag(true);
    phone.setType(PhoneDescriptionType.OFFICE);
    phoneTypeRepository.save(phone);
    
    assertThat(phoneTypeRepository.findAllByType(PhoneDescriptionType.OFFICE)).isNotEmpty();
  }
}
