package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.Risk;

public interface RiskRepository extends CrudRepository<Risk, Integer> {

  
}
