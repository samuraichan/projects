package starter.book.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Book;
import starter.repository.BookAuditRepository;
import starter.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BookTest {
  
  @Autowired
  private BookRepository bookRepository;
  
  @Autowired
  private BookAuditRepository bookAuditRepository;

  @Before
  public void setup() {
    
  }
  
  @Test
  public void testBookInsert() {
    
    assertThat(bookAuditRepository.findAll()).isEmpty();
    
    Book book = new Book();
    book.setAuthor("Jonathan Harr");
    book.setTitle("A Civil Action");
    book.setIsbn("0679772677");
    assertThat(book.getBookId()).isNull();
    
    book = bookRepository.save(book);
    assertThat(book.getBookId()).isNotNull();
    
    assertThat(bookAuditRepository.findAll()).isNotEmpty();
  }
}
