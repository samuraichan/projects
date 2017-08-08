package starter.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.Quote;

public interface QuoteRepository extends CrudRepository<Quote, Integer> { 

  public Collection<Quote> findAll();
  
}
