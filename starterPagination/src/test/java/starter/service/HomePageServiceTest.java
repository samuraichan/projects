package starter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.concurrent.ThreadLocalRandom;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.model.PaginationParams;
import starter.data.model.RiskStatus;
import starter.data.model.SearchFilter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class HomePageServiceTest {
  
private static final int TOTAL_RISK_RECORDS = 20;
  
  private static final int DRAFT_RISK_COUNT = 5;
  
  private static final int IN_PROGRESS_RISK_COUNT = 4;
  
  private static final int COMPLETED_RISK_COUNT = 11;

  @Autowired
  private HomePageService homePageService;
  
  @Test
  public void testPaginationParamsEmpty() {
    PaginationParams params = new PaginationParams(null, null, null);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testRecordsFilteredLength() {
    int offset = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    PaginationParams params = new PaginationParams(null, offset, null);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS - offset);
  }
  
  @Test
  public void testRecordFilteredExceptionMinOffset() {
    int offset = Integer.MIN_VALUE;
    PaginationParams params = new PaginationParams(null, offset, null);
    assertThatThrownBy(() -> {
      assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered());}
    ).isInstanceOf(Exception.class);
  }
  
  @Test
  public void testEmptyFilter() {
    SearchFilter filter = new SearchFilter(null, null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testFilterDraftStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.DRAFT.getCode(), null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(DRAFT_RISK_COUNT);
  }
  
  @Test
  public void testFilterNotExistMaxStatus() {
    SearchFilter filter = new SearchFilter(Integer.MAX_VALUE, null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(0);
  }
  
  @Test
  public void testFilterNotExistMinStatus() {
    SearchFilter filter = new SearchFilter(Integer.MIN_VALUE, null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(0);
  }
  
  @Test
  public void testFilterInProgressStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.INPROGRESS.getCode(), null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(IN_PROGRESS_RISK_COUNT);
  }
  
  @Test
  public void testFilterCompletedStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(COMPLETED_RISK_COUNT);
  }
  
  @Test
  public void testFilterStartDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, dateTime.toDate(), null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(3);
  }
  
  @Test
  public void testFilterEndDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(17);
  }
  
  @Test
  public void testFilterRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, startDate.toDate(), endDate.toDate());
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(2);
  }
  
  @Test
  public void testFilterCompletedStatusRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), startDate.toDate(), endDate.toDate());
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(1);
  }
}
