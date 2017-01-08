package starter.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.BookAudit;

/**
 * This repository tracks the <code>BOOK_AUDIT</code> table populated by Hibernate's Envers functionality
 */
public interface BookAuditRepository extends CrudRepository<BookAudit, Integer> {

  /**
   * Find all <code>BookAudit</code> entities 
   * 
   * @return
   */
  public Collection<BookAudit> findAll();
}
