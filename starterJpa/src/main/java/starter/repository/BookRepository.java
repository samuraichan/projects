package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

  /**
   * Persist a <code>RiskHeader</code>
   * 
   * @param riskHeader
   */
  public Book save(Book book);
}
