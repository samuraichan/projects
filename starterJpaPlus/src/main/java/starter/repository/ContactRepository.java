package starter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import starter.data.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
