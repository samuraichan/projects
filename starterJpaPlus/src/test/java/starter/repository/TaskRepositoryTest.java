package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class TaskRepositoryTest {

  @Autowired
  private TaskRepository repository;
  
  @Test
  public void testEmpty() {
    assertThat(repository.findAll()).isEmpty();
  }
  
  @Test
  public void testIndividualInsert() {
    Task task = new Task();
    task.setDescription("Mow Lawn");
    task.setActiveFlag(true);
    repository.save(task);
    
    assertThat(repository.findAll()).isNotEmpty();
  }
}
