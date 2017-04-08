package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.PhoneTypeDescription;
import starter.types.PhoneDescriptionType;

public interface PhoneTypeDescriptionRepository extends CrudRepository<PhoneTypeDescription, Integer>{

  public Iterable<PhoneTypeDescription> findAllByType(PhoneDescriptionType type);
}