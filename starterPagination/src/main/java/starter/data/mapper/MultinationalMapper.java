package starter.data.mapper;

import org.springframework.stereotype.Repository;

import starter.data.multinational.data.Detail;

@Repository
public interface MultinationalMapper {

  public Detail findDetailByRisk(Integer riskId);
}
