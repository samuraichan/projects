package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Contact;
import starter.data.model.MailingAddress;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class ContactRepositoryTest {

  @Autowired
  private ContactRepository contactRepository;
  
  @Test
  public void testEmbedabbleMailingAddress() {
    for(Contact contact : contactRepository.findAll()) {
      assertThat(contact.getMailingAddress().getStreet()).isNotEmpty();
      assertThat(contact.getMailingAddress().getCity()).isNotEmpty();
      assertThat(contact.getMailingAddress().getPostalCode()).isNotEmpty();
    }
  }
  
  @Test
  public void testInsertEmbedabbleMailingAddress() {
    Contact contact = new Contact();
    MailingAddress address = new MailingAddress();
    address.setCity("Riverton");
    address.setStreet("190 Redwood Rd");
    address.setPostalCode("98683");
    contact.setMailingAddress(address);
    contact.setActiveFlag(true);
    Integer contactId = contactRepository.save(contact).getId();
    
    contact = contactRepository.findOne(contactId);
    assertThat(contact.getMailingAddress().getCity()).isEqualTo("Riverton");
    assertThat(contact.getMailingAddress().getPostalCode()).isEqualTo("98683");
  }
}
