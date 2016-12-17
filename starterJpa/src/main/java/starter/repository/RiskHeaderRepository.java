package starter.repository;

import org.springframework.data.repository.Repository;

import starter.data.entity.RiskHeader;

public interface RiskHeaderRepository extends Repository<RiskHeader, Integer> {

  /**
   * Persist a <code>RiskHeader</code>
   * 
   * @param riskHeader
   */
  public void save(RiskHeader riskHeader);
}
