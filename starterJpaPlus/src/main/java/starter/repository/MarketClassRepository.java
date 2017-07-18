package starter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import starter.data.entity.MarketClass;

@Repository
public interface MarketClassRepository extends CrudRepository<MarketClass, Integer> {

  public List<MarketClass> findAll();
}
