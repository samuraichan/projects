package starter.data.model;

import java.io.Serializable;

public class IdAndDescription implements Cloneable {

  private Integer id;
  
  private String description;
  
  public IdAndDescription() {}
  
  public IdAndDescription(Integer id, String descprition) {
    this.id = id;
    this.description = descprition;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    IdAndDescription other = (IdAndDescription) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
      return super.clone();
  }
  
  
}
