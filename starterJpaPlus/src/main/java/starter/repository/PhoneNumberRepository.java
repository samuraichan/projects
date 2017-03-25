package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

}
