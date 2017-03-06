package starter.data.model;

public class PaginationParams {

  private Integer start;
  
  private Integer length;
  
  private SearchFilter searchFilter;
  
  public PaginationParams(Integer start, Integer length, SearchFilter searchFilter) {
    this.start = start;
    this.length = length;
    this.searchFilter = searchFilter;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public SearchFilter getSearchFilter() {
    return searchFilter;
  }

  public void setSearchFilter(SearchFilter searchFilter) {
    this.searchFilter = searchFilter;
  }
}
