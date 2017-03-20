package starter.data.model;

import java.util.Date;

public class SearchFilter {

  private Integer statusId;
  
  private Date startDate;
  
  private Date endDate;
  
  public SearchFilter() {}
  
  public SearchFilter(Integer statusId, Date startDate, Date endDate) {
    this.statusId = statusId;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Integer getStatusId() {
    return statusId;
  }

  public void setStatusId(Integer statusId) {
    this.statusId = statusId;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}
