package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{

}
