package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  public Person findByLastName(String lastName);
}
