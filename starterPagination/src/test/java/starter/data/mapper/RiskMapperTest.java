package starter.data.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.model.DataTablesInput;
import starter.data.model.DataTablesOutput;
import starter.data.model.RiskStatus;
import starter.data.model.Search;
import starter.data.model.SearchFilter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class RiskMapperTest {
  
  private static final int TOTAL_RISK_RECORDS = 34;
  
  private static final int DRAFT_RISK_COUNT = 8;
  
  private static final int IN_PROGRESS_RISK_COUNT = 6;
  
  private static final int COMPLETED_RISK_COUNT = 20;
  
  private static final int NO_RECORDS = 0; 
  
  private static final int TWENTY_SEARCH_RECORDS = 10;

  @Autowired
  private RiskMapper riskMapper;
  
  @Test
  public void testNullDataTablesInput() {
    assertThat(riskMapper.findDataTablesOutput(null).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testEmptyDataTablesInput() {
    DataTablesInput input = new DataTablesInput();
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
  }
    
  @Test 
  public void testDataTablesTotalRecordPlusStartIndex() {
    int start = TOTAL_RISK_RECORDS + 1;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(riskMapper.findDataTablesOutput(input)).isNull();
  }
  
  @Test 
  public void testDataTablesMaxStartIndex() {
    int start = Integer.MAX_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(riskMapper.findDataTablesOutput(input)).isNull();
  }
  
  @Test 
  public void testDataTablesMinStartIndex() {
    int start = Integer.MIN_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
   
    assertThatThrownBy(() -> {
      riskMapper.findDataTablesOutput(input);}
    ).isInstanceOf(Exception.class);
  }
  
  @Test
  public void testDataTablesStartIndexAtTotalRecord() {
    int start = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(riskMapper.findDataTablesOutput(input)).isNull();
  }
  
  @Test
  public void testDataTablesStatIndexIncrementOfTen() { // this best mimics what datatables will send
    int start[] = {10,20,30};
    for (int i : start) {
      DataTablesInput input = new DataTablesInput();
      input.setStart(i);
      assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
      assertThat(riskMapper.findDataTablesOutput(input).getData().size()).isEqualTo(TOTAL_RISK_RECORDS - i);
    }
  }
  
  @Test
  public void testFilterDraftStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.DRAFT.getCode(), null, null);
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(DRAFT_RISK_COUNT);
  }
  
  @Test
  public void testFilterNotExistMaxStatus() {
    SearchFilter filter = new SearchFilter(Integer.MAX_VALUE, null, null);
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input)).isNull();
  }
  
  @Test
  public void testFilterNotExistMinStatus() {
    SearchFilter filter = new SearchFilter(Integer.MIN_VALUE, null, null);
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input)).isNull();
  }
  
  @Test
  public void testFilterInProgressStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.INPROGRESS.getCode(), null, null);
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(IN_PROGRESS_RISK_COUNT);
  }
  
  @Test
  public void testFilterCompletedStatus() {
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), null, null);
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(COMPLETED_RISK_COUNT);
  }
  
  @Test
  public void testFilterStartDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, dateTime.toDate(), null);
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(3);
  }
  
  @Test
  public void testFilterEndDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
    assertThat(riskMapper.findAllBySearchFilter(filter)).size().isEqualTo(31);
  }
  
  @Test
  public void testFilterRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, startDate.toDate(), endDate.toDate());
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(2);
  }
  
  @Test
  public void testFilterCompletedStatusRangeDate() {
    DateTime startDate = new DateTime(2017, 10, 1, 0, 0);
    DateTime endDate = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(RiskStatus.COMPLETED.getCode(), startDate.toDate(), endDate.toDate());
    DataTablesInput input = new DataTablesInput();
    input.setSearchFilter(filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(1);
  }
  
  @Test
  public void testOutputFilterEndDate() {
    DateTime dateTime = new DateTime(2017, 10, 16, 0, 0);
    SearchFilter filter = new SearchFilter(null, null, dateTime.toDate());
    DataTablesInput input = new DataTablesInput(null, null, 10, null, filter);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(31);
  }
  
  // Datatables search filter
  
  @Test
  public void testOutputFilterEndDateWithStartIndex() {
    DataTablesInput input = new DataTablesInput(null, 0, 10, new Search("th"), null);
    assertThat(riskMapper.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(8);
  }
  
  @Test
  public void testDataTablesSearch() {
    int start = 0;
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    input.setSearch(new Search(""));
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testDataTablesSearch2() {
    int start = 0;
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    input.setSearch(new Search("twenty"));
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(10);
  }
  
  @Test
  public void testDataTablesSearch3() {
    int start = 0;
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    input.setSearch(new Search("thirty"));
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(5);
  }
  
  @Test
  public void testDataTablesSearch4() {
    int start = 10;
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    input.setSearch(new Search("twenty"));
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    assertThat(output).isNull();
  }
  
  @Test
  public void testDataTablesSearch5() {
    int start = 5;
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    input.setSearch(new Search("twenty"));
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(5);
    assertThat(output.getRecordsFiltered()).isEqualTo(10);
  }
  
  @Test
  public void testDataTablesSearch6() {
    int start = 5;
    int length = 3;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    input.setSearch(new Search("twenty"));
    DataTablesOutput output = riskMapper.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(length);
    assertThat(output.getRecordsFiltered()).isEqualTo(10);
  }
  
}
