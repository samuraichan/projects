package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_aud")
public class BookAudit {
  
  @Id
  @Column(name="book_aud_id")
  private Integer bookAuditId;
  
  @Column(name="book_id")
  private Integer bookId;
  
  @Column(name = "author")
  private String author;
  
  @Column(name = "title")
  private String title;
  
  @Column(name = "isbn")
  private String isbn;
  
  @Column(name = "rev")
  private Integer rev;
  
  @Column(name = "revtype")
  private Byte revType;

  
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

  public Integer getRev() {
    return rev;
  }

  public void setRev(Integer rev) {
    this.rev = rev;
  }

  public Byte getRevType() {
    return revType;
  }

  public void setRevType(Byte revType) {
    this.revType = revType;
  }

  public Integer getBookAuditId() {
    return bookAuditId;
  }

  public void setBookAuditId(Integer bookAuditId) {
    this.bookAuditId = bookAuditId;
  } 
}
