package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.PhoneTypeValue;
import starter.types.PhoneValueType;

public interface PhoneTypeValueRepository extends CrudRepository<PhoneTypeValue, Integer>{

  public Iterable<PhoneTypeValue> findAllByType(PhoneValueType type);
}
