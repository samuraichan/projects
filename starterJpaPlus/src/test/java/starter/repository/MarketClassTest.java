package starter.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.entity.MarketClass;
import starter.types.MarketClassType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class MarketClassTest {

  @Autowired
  private MarketClassRepository repository;
  
 
  @Test
  public void testFindAllClasses() {
    
    List<MarketClass> marketClasses = repository.findAll();
    assertThat(marketClasses.size()).isEqualTo(8);
  }
  
  @Test
  public void testNotEmptyStream() {
    List<MarketClass> marketClasses = repository.findAll();
    
    List<MarketClass> resultClasses = marketClasses.stream().filter(mc -> mc.isSelected() != null && mc.isSelected()).collect(Collectors.toList());
    assertThat(resultClasses.size()).isEqualTo(3);
    assertThat(marketClasses.size()).isEqualTo(8);
  }
  
  @Test
  public void testEmptyStream() {
    List<MarketClass> newClasses = new ArrayList<>();
    newClasses = newClasses.stream().filter(mc -> mc.isSelected() != null && mc.isSelected()).collect(Collectors.toList());
    assertThat(newClasses).isEmpty();
  }
  
  @Test
  public void testStreamLogic() {
    List<MarketClass> marketClasses = repository.findAll();
    List<MarketClass> resultClasses = marketClasses.stream().filter(mc -> mc.getTypeId().equals(MarketClassType.PROPERTY.getValue())).collect(Collectors.toList());
    assertThat(resultClasses.size()).isEqualTo(4);
  }
  
  @Test
  public void testStreamContains() {
    List<MarketClass> marketClasses = repository.findAll();
    assertThat(marketClasses.stream().filter(mc -> mc.getTypeId().equals(MarketClassType.PROPERTY.getValue())).findFirst().isPresent()).isTrue();
    assertThat(marketClasses.stream().filter(mc -> mc.getTypeId().equals(MarketClassType.VARIABLE_QUOTE.getValue())).findFirst().isPresent()).isFalse();
  }
  
  @Test
  public void testStreamMapTo() {
    List<MarketClass> marketClasses = repository.findAll();
    Map<Integer, List<MarketClass>> groupByType = marketClasses.stream().collect(Collectors.groupingBy(MarketClass::getTypeId));
    System.out.println("dude");
    
    
  }
  
  
}
