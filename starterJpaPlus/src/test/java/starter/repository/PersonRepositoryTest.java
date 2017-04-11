package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Address;
import starter.data.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class PersonRepositoryTest {

  @Autowired
  private PersonRepository personRepository;
  
  @Test
  public void testMyDate() {
    Person p = new Person("Raul", "Chiariss", null, true);
    p.setTimestamp(new Timestamp(new Date().getTime()));
    personRepository.save(p);
  }
  
  @Test
  public void testLikeExpressionWithInternationalChars() {
    Person p = new Person("Raul", "翻訳するテキストや", null, true);
    personRepository.save(p);
    
    p = personRepository.findByLastNameLike("%トや%");
    assertThat(p.getId()).isNotNull();
  }
  
  @Test
  public void testRepositoryEmpty() {
    Person p = new Person("Raul", "Chiari", null, true);
    personRepository.save(p);
    
    p = personRepository.findByLastName("Chiari");
    assertThat(p.getId()).isNotNull();
  }
  
  @Test
  public void testAddressesIsNullOrEmpty() {
    Person p = new Person("Raul", "Chiari1", null, true);
    p.setAge(40);
    p = personRepository.save(p);
    assertThat(p.getAddresses()).isNull();
    
    p = personRepository.findByLastName("Chiari1");
    assertThat(p.getAddresses()).isEmpty();
    
    //p.setLastName("Chiari Has been modified");
    p.setAge(41);
    personRepository.save(p);
  }
  
  @Test
  public void testAddressesInit() {
    Person p = new Person("Raul", "Chiari2", null, true);
    personRepository.save(p);
    p = personRepository.findByLastName("Chiari2");
    assertThat(p.getAddresses()).isEmpty();
    
    Person p3 = new Person("Raul", "Chiari3", Collections.<Address>emptyList(), true);
    personRepository.save(p3);
    p3 = personRepository.findByLastName("Chiari3");
    assertThat(p3.getAddresses()).isEmpty();
    
    Person p4 = new Person("Raul", "Chiari4", new ArrayList<Address>(), true);
    personRepository.save(p4);
    p4 = personRepository.findByLastName("Chiari4");
    assertThat(p4.getAddresses()).isEmpty();
  }
  
  @Test
  public void testAddressManipulation() {
    Person p = new Person("Raul", "Chiari5", new ArrayList<Address>(), true);
    
    p.getAddresses().add(new Address("1st Street", "MS", "Vicksburg", "39181", null, true));
    p.getAddresses().add(new Address("1804 NE Avue", "WA", "Vancouver", "98683", null, true));
    p.getAddresses().add(new Address("1804 NewBold LN", "UT", "Riverton", "84056", null, true));

    personRepository.save(p);
    p = personRepository.findByLastName("Chiari5");
    assertThat(p.getAddresses()).isEmpty();
    
    p.getAddresses().add(new Address("1st Street", "MS", "Vicksburg", "39181", p, true));
    p.getAddresses().add(new Address("1804 NE Avue", "WA", "Vancouver", "98683", p, false));
    p.getAddresses().add(new Address("1804 NewBold LN", "UT", "Riverton", "84056", null, true));
    
    personRepository.save(p);
    p = personRepository.findByLastName("Chiari5");
    assertThat(p.getAddresses().size()).isEqualTo(1);
    
    for (Address address : p.getAddresses()) {
      address.setActiveFlag(false);
    }
    
    personRepository.save(p);
    p = personRepository.findByLastName("Chiari5");
    assertThat(p.getAddresses()).isEmpty();
    
    p.getAddresses().add(new Address("2n Street", "MS", "Vicksburg", "39181", p, true));
    personRepository.save(p);
    p = personRepository.findByLastName("Chiari5");
    assertThat(p.getAddresses().size()).isEqualTo(1);
    
    
  }
}