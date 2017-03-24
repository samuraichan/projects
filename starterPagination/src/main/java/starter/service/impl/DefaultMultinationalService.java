package starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import starter.data.mapper.MultinationalMapper;
import starter.data.multinational.data.Detail;
import starter.service.MultinatinalService;

@Service
public class DefaultMultinationalService implements MultinatinalService {
  
  private final MultinationalMapper multinationalMapper;
  
  @Autowired
  public DefaultMultinationalService(MultinationalMapper multinationalMapper) {
    this.multinationalMapper = multinationalMapper;
  }
  
  @Override
  public Detail findDetailByRisk(Integer riskId) {
    return multinationalMapper.findDetailByRisk(riskId);
  }

}
