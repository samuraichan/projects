package starter.data.mapper;

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
public class RiskMapperTest {
  
  private static final int TOTAL_RISK_RECORDS = 20;
  
  private static final int DRAFT_RISK_COUNT = 5;
  
  private static final int IN_PROGRESS_RISK_COUNT = 4;
  
  private static final int COMPLETED_RISK_COUNT = 11;

  @Autowired
  private RiskMapper riskMapper;
  
  @Test
  public void testNullFilter() {
    assertThat(riskMapper.findAllBySearchFilter(null)).isNotEmpty();
  }
  
  @Test
  public void testEmptyFilter() {
    assertThat(riskMapper.findAllBySearchFilter(new SearchFilter(null, null, null))).isNotEmpty();
  }
  
  @Test
  public void testFilterDraftStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.DRAFT.getCode(), null, null);
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(DRAFT_RISK_COUNT);
  }
  
  @Test
  public void testFilterNotExistMaxStatus() {
    SearchFilter filter = new SearchFilter(Integer.MAX_VALUE, null, null);
    assertThat(riskMapper.findAllBySearchFilter(filter)).isEmpty();;
  }
  
  @Test
  public void testFilterNotExistMinStatus() {
    SearchFilter filter = new SearchFilter(Integer.MIN_VALUE, null, null);
    assertThat(riskMapper.findAllBySearchFilter(filter)).isEmpty();;
  }
  
  @Test
  public void testFilterInProgressStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.INPROGRESS.getCode(), null, null);
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(IN_PROGRESS_RISK_COUNT);
  }
  
  @Test
  public void testFilterCompletedStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), null, null);
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(COMPLETED_RISK_COUNT);
  }
  
  @Test
  public void testFilterStartDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, dateTime.toDate(), null);
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(3);
  }
  
  @Test
  public void testFilterEndDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(17);
  }
  
  @Test
  public void testFilterRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, startDate.toDate(), endDate.toDate());
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(2);
  }
  
  @Test
  public void testFilterCompletedStatusRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), startDate.toDate(), endDate.toDate());
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(1);
  }
  
  @Test
  public void testNullPaginationParams() {
    assertThat(riskMapper.findAllByPaginationParams(null)).isNotEmpty();
  }
  
  @Test
  public void testEmptyPaginationParams() {
    PaginationParams params = new PaginationParams(null, null, null);
    assertThat(riskMapper.findAllByPaginationParams(params)).isNotEmpty();
  }
  
  @Test
  public void testPaginationParamsDraftStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.DRAFT.getCode(), null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(DRAFT_RISK_COUNT);
  }
  
  @Test
  public void testPaginationParamsNotExistMaxStatus() {
    SearchFilter filter = new SearchFilter(Integer.MAX_VALUE, null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).isEmpty();;
  }
  
  @Test
  public void testPaginationParamsNotExistMinStatus() {
    SearchFilter filter = new SearchFilter(Integer.MIN_VALUE, null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).isEmpty();;
  }
  
  @Test
  public void testPaginationParamsInProgressStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.INPROGRESS.getCode(), null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(IN_PROGRESS_RISK_COUNT);
  }
  
  @Test
  public void testPaginationParamsCompletedStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), null, null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(COMPLETED_RISK_COUNT);
  }
  
  @Test
  public void testPaginationParamsStartDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, dateTime.toDate(), null);
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(3);
  }
  
  @Test
  public void testPaginationParamsEndDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(17);
  }
  
  @Test
  public void testPaginationParamsRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, startDate.toDate(), endDate.toDate());
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(2);
  }
  
  @Test
  public void testPaginationParamsCompletedStatusRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), startDate.toDate(), endDate.toDate());
    PaginationParams params = new PaginationParams(null, null, filter);
    assertThat(riskMapper.findAllByPaginationParams(params)).size().isEqualTo(1);
  }
  
  @Test
  public void testPaginationParamsEmpty() {
    PaginationParams params = new PaginationParams(null, null, null);
    assertThat(riskMapper.findDataTablesOutputByPaginationParams(params).getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testRecordsFilteredLength() {
    int offset = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    PaginationParams params = new PaginationParams(null, offset, null);
    assertThat(riskMapper.findDataTablesOutputByPaginationParams(params).getData().size()).isEqualTo(TOTAL_RISK_RECORDS - offset);
  }
  
  @Test
  public void testRecordFilteredExceptionMinOffset() {
    int offset = Integer.MIN_VALUE;
    PaginationParams params = new PaginationParams(null, offset, null);
    assertThatThrownBy(() -> {
      assertThat(riskMapper.findDataTablesOutputByPaginationParams(params).getData());}
    ).isInstanceOf(Exception.class);
  }
}
