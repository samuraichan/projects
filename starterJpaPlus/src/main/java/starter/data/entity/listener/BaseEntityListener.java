package starter.data.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import starter.data.entity.BaseEntity;

public class BaseEntityListener {

  @PrePersist
  public void setCreatedDate(BaseEntity baseEntity) {
    baseEntity.setCreatedDate(new Date());
  }
  
  @PreUpdate
  public void setUpdatedDate(BaseEntity baseEntity) {
    baseEntity.setUpdatedDate(new Date());
  }
}
