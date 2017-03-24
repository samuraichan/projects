package starter.service;

import org.springframework.stereotype.Service;

import starter.data.multinational.data.Detail;


public interface MultinatinalService {

  public Detail findDetailByRisk(Integer riskId);
}
