
package starter.data.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  protected Integer id;
  
  @Column(name="active_flag")
  @Type(type="yes_no")
  private boolean activeFlag;
  
  @Version
  @Column(name="version_number")
  protected Integer version = 1;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isNew() {
    return this.id == null;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }
  
  public boolean getActiveFlag() {
    return activeFlag;
  }

  public void setActiveFlag(boolean activeFlag) {
    this.activeFlag = activeFlag;
  }
}
