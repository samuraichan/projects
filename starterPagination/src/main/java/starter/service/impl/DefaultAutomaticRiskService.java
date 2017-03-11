package starter.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;

import starter.data.mapper.AutomaticRiskMapper;
import starter.data.model.AutomaticRisk;
import starter.data.multinational.data.Document;
import starter.service.AutomaticRiskService;

@Service
public class DefaultAutomaticRiskService implements AutomaticRiskService {
  
  private final AutomaticRiskMapper automaticRiskMapper;
  
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @Autowired
  public DefaultAutomaticRiskService(AutomaticRiskMapper automaticRiskMapper, MappingJackson2XmlHttpMessageConverter xmlConverter) {
    this.automaticRiskMapper = automaticRiskMapper;
    this.xmlConverter = xmlConverter;
  }

  @Override
  public Collection<AutomaticRisk> findAll() {
    return automaticRiskMapper.findAll();
  }

  @Override
  public AutomaticRisk findByRiskId(Integer riskId) {
    return automaticRiskMapper.findByRiskId(riskId);
  }

  @Override
  public Document findMultinationalDocumentByRiskId(Integer riskId) throws Exception {
    AutomaticRisk risk = findByRiskId(riskId);
    return xmlConverter.getObjectMapper().readValue(risk.getXml(), Document.class);
  }

}
