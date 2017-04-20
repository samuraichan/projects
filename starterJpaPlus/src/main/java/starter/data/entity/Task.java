package starter.data.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.transaction.Transactional;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

@Entity
@Table(name="task")
@Audited
@Where(clause="active_flag = 'Y'")
public class Task {
  
  private Integer id;
  
  private String description;
  
  @Column(name="active_flag")
  @Type(type="yes_no")
  @Access( AccessType.FIELD )
  private boolean activeFlag;
  
  private Date createdDate;
  
  private Date updatedDate;
  
  private Integer version;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isActiveFlag() {
    return activeFlag;
  }

  public void setActiveFlag(boolean activeFlag) {
    this.activeFlag = activeFlag;
  }

  @Column(name="created_date")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Column(name="updated_date")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Version
  @Column(name="version_number")
  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  @Transient
  public Integer getMyVersion() {
    return version + 1;
  }
}
