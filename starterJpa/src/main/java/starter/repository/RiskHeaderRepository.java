package starter.repository;

import org.springframework.data.repository.CrudRepository;

import starter.data.entity.RiskHeader;

public interface RiskHeaderRepository extends CrudRepository<RiskHeader, Integer> {

  /**
   * Persist a <code>RiskHeader</code>
   * 
   * @param riskHeader
   */
  public RiskHeader save(RiskHeader riskHeader);
  
  /**
   * 
   * @param namedInsured
   * @return
   */
  public RiskHeader findByNamedInsured(String namedInsured);
  
  public RiskHeader findById(Integer id);
}
