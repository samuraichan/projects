package starter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class HomePageServiceTest {
  
private static final int TOTAL_RISK_RECORDS = 34;
  
  private static final int DRAFT_RISK_COUNT = 5;
  
  private static final int IN_PROGRESS_RISK_COUNT = 4;
  
  private static final int COMPLETED_RISK_COUNT = 11;
  
  private static final int NO_RECORDS = 0; 

  @Autowired
  private HomePageService homePageService;
  
  @Test
  public void testNullDataTablesInput() {
    assertThat(homePageService.findDataTablesOutput(null).getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testEmptyDataTablesInput() {
    DataTablesInput input = new DataTablesInput();
    assertThat(homePageService.findDataTablesOutput(input).getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  // Datatables start index TESTS
  
  
  @Test 
  public void testDataTablesRandomStartIndex() {
    int start = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo((TOTAL_RISK_RECORDS - start));
  }
  
  @Test 
  public void testDataTablesTotalRecordPlusStartIndex() {
    int start = TOTAL_RISK_RECORDS + 1;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(NO_RECORDS);
  }
  
  @Test 
  public void testDataTablesMaxStartIndex() {
    int start = Integer.MAX_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(NO_RECORDS);
  }
  
  @Test 
  public void testDataTablesMinStartIndex() {
    int start = Integer.MIN_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
   
    assertThatThrownBy(() -> {
      homePageService.findDataTablesOutput(input);}
    ).isInstanceOf(Exception.class);
  }
  
  @Test
  public void testDataTablesStartIndexAtTotalRecord() {
    int start = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(NO_RECORDS);
  }
  
  @Test
  public void testDataTablesStatIndexIncrementOfTen() { // this best mimics what datatables will send
    int start[] = {10,20,30,40,50,60,70,80,90,100};
    for (int i : start) {
      DataTablesInput input = new DataTablesInput();
      input.setStart(i);
      
      int compareTo = (i > TOTAL_RISK_RECORDS ? NO_RECORDS : (TOTAL_RISK_RECORDS - i));
      assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(compareTo);
    }
  }
  
  // Datatables length index TESTS
  
  @Test 
  public void testDataTablesRandomLengthIndex() {
    int length = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(length);
  }
  
  @Test 
  public void testDataTablesTotalRecordPlusLengthIndex() {
    int length = TOTAL_RISK_RECORDS + 1;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test 
  public void testDataTablesMaxLengthIndex() {
    int length = Integer.MAX_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test 
  public void testDataTablesMinLengthIndex() {
    int length = Integer.MIN_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
   
    assertThatThrownBy(() -> {
      homePageService.findDataTablesOutput(input);}
    ).isInstanceOf(Exception.class);
  }
  
  @Test
  public void testDataTablesLengthIndexAtTotalRecord() {
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  // Datatables combination of length and start index(es) TESTS
  
//  @Test
//  public void testRecordsFilteredLength() {
//    int offset = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
//    PaginationParams params = new PaginationParams(null, offset, null);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS - offset);
//  }
//  
//  @Test
//  public void testRecordFilteredExceptionMinOffset() {
//    int offset = Integer.MIN_VALUE;
//    PaginationParams params = new PaginationParams(null, offset, null);
//    assertThatThrownBy(() -> {
//      assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered());}
//    ).isInstanceOf(Exception.class);
//  }
//  
//  @Test
//  public void testEmptyFilter() {
//    SearchFilter filter = new SearchFilter(null, null, null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
//  }
//  
//  @Test
//  public void testFilterDraftStatus() {
//    SearchFilter filter = new SearchFilter(RiskStatus.DRAFT.getCode(), null, null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(8);
//  }
//  
//  @Test
//  public void testFilterNotExistMaxStatus() {
//    SearchFilter filter = new SearchFilter(Integer.MAX_VALUE, null, null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(0);
//  }
//  
//  @Test
//  public void testFilterNotExistMinStatus() {
//    SearchFilter filter = new SearchFilter(Integer.MIN_VALUE, null, null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(0);
//  }
//  
//  @Test
//  public void testFilterInProgressStatus() {
//    SearchFilter filter = new SearchFilter(RiskStatus.INPROGRESS.getCode(), null, null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(6);
//  }
//  
//  @Test
//  public void testFilterCompletedStatus() {
//    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), null, null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(20);
//  }
//  
//  @Test
//  public void testFilterStartDate() {
//    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
//    SearchFilter filter = new SearchFilter(null, dateTime.toDate(), null);
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(3);
//  }
//  
//  @Test
//  public void testFilterEndDate() {
//    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
//    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(31);
//  }
//  
//  @Test
//  public void testFilterRangeDate() {
//    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
//    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
//    SearchFilter filter = new SearchFilter(null, startDate.toDate(), endDate.toDate());
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(2);
//  }
//  
//  @Test
//  public void testFilterCompletedStatusRangeDate() {
//    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
//    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
//    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), startDate.toDate(), endDate.toDate());
//    PaginationParams params = new PaginationParams(null, null, filter);
//    assertThat(homePageService.findDataTablesOutputByPaginationParams(params).getRecordsFiltered()).isEqualTo(1);
//  }
//  
//  @Test
//  public void testOutputCompletedStatusRangeDate() {
//    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
//    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
//    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), startDate.toDate(), endDate.toDate());
//    DataTablesInput input = new DataTablesInput(null, null, null, null, filter);
//    assertThat(homePageService.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(1);
//  }
//  
//  @Test
//  public void testOutputFilterEndDate() {
//    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
//    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
//    DataTablesInput input = new DataTablesInput(null, null, 10, null, filter);
//    assertThat(homePageService.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(10);
//  }
//  
//  @Test
//  public void testOutputFilterEndDateWithStartIndex() {
//    DataTablesInput input = new DataTablesInput(null, 0, 10, new Search("th"), null);
//    assertThat(homePageService.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(8);
//  }
}
