package starter.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.Submission;

public interface SubmissionRepository extends CrudRepository<Submission, Integer> { 

  public Collection<Submission> findAll();
  
}
