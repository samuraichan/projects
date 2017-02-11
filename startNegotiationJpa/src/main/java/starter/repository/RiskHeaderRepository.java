package starter.repository;

import org.springframework.data.jpa.repository.Query;
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
  
  /**
   * Find a <code>RiskHeader</code> by a primary identifier
   * @param id
   * @return
   */
  public RiskHeader findById(Integer id);
  
  /**
   * Find all <code>RiskHeader(s)</code> that are active
   * @return
   */
  @Query("SELECT COUNT(risk) FROM RiskHeader risk WHERE risk.activeFlag = 'Y'")
  public Long countByActive();
  
  /**
   * Find all <code>RiskHeader(s)</code> that are inactive
   * @return
   */
  @Query("SELECT COUNT(risk) FROM RiskHeader risk WHERE risk.activeFlag = 'N'")
  public Long countByInActive();
}
