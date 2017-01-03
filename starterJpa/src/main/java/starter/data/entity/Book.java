package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name="book")
@Audited
public class Book {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="book_id")
  private Integer bookId;
  
  @Column(name = "author")
  private String author;
  
  @Column(name = "title")
  private String title;
  
  @Column(name = "isbn")
  private String isbn;

  
  public Integer getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
