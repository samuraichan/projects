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
import starter.data.model.Search;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class HomePageServiceTest {
  
private static final int TOTAL_RISK_RECORDS = 34;
  
  private static final int DRAFT_RISK_COUNT = 5;
  
  private static final int IN_PROGRESS_RISK_COUNT = 4;
  
  private static final int COMPLETED_RISK_COUNT = 11;
  
  private static final int NO_RECORDS = 0; 
  
  private static final int TWENTY_SEARCH_RECORDS = 10;

  @Autowired
  private HomePageService homePageService;
    
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
    assertThat(homePageService.findDataTablesOutput(input).getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(NO_RECORDS);
  }
  
  @Test 
  public void testDataTablesMaxStartIndex() {
    int start = Integer.MAX_VALUE;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    assertThat(homePageService.findDataTablesOutput(input).getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
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
  public void testDataTablesStatIndexIncrementOfTen0() { // this best mimics what datatables will send
    int start = 0;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test
  public void testDataTablesStatIndexIncrementOfTen1() { // this best mimics what datatables will send
    int start = 10;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS - start);
  }
  
  @Test
  public void testDataTablesStatIndexIncrementOfTen2() { // this best mimics what datatables will send
    int start = 20;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS - start);
  }
  
  @Test
  public void testDataTablesStatIndexIncrementOfTen3() { // this best mimics what datatables will send
    int start = 30;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS - start);
  }
  
  @Test
  public void testDataTablesRandomStartIndexIncrementOfTen() { // this best mimics what datatables will send
    int start = ThreadLocalRandom.current().nextInt(10, 30);
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS - start);
  }
  
  @Test
  public void testDataTablesStatIndexIncrementOfTen4() { // this best mimics what datatables will send
    int start = 40;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(NO_RECORDS);
    assertThat(output.getData().size()).isEqualTo(NO_RECORDS);
  }
  
  @Test
  public void testDataTablesRandomStartIndexUpperBoundIncrementOfTen() { // this best mimics what datatables will send
    int start = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(NO_RECORDS);
    assertThat(output.getData().size()).isEqualTo(NO_RECORDS);
  }
    
  // Datatables length index TESTS
  
  @Test 
  public void testDataTablesRandomLengthIndex1() {
    int length = 1;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(length);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
  }
  
  @Test 
  public void testDataTablesRandomLengthIndex2() {
    int length = 0;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(NO_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(NO_RECORDS);
  }
  
  @Test 
  public void testDataTablesTotalRecordPlusLengthIndex() {
    int length = TOTAL_RISK_RECORDS + 1;
    DataTablesInput input = new DataTablesInput();
    input.setLength(length);
    assertThat(homePageService.findDataTablesOutput(input).getData().size()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(homePageService.findDataTablesOutput(input).getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
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
  
  @Test 
  public void testDataTablesRandomStartAndLengthIndex() {
    int start = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    int length = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(output.getData().size() < length ? output.getData().size() : length);
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght() {
    int start = ThreadLocalRandom.current().nextInt(0, (TOTAL_RISK_RECORDS-1) + 1);
    int length = TOTAL_RISK_RECORDS;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getData().size()).isEqualTo(TOTAL_RISK_RECORDS - start);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1() {
    int start = 0;
    int length = 10;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(length);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1a() {
    int start = 10;
    int length = 10;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(length);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1b() {
    int start = 10;
    int length = 25;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(24);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1c() {
    int start = 20;
    int length = 25;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(14);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1d() {
    int start = 25;
    int length = 25;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(9);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1e() {
    int start = 30;
    int length = 5;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(4);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1f() {
    int start = 30;
    int length = 3;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(3);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1g() {
    int start = 16;
    int length = 20;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(18);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
  
  @Test 
  public void testDataTablesFirstRecordWithStartAndLenght1h() {
    int start = 16;
    int length = 17;
    DataTablesInput input = new DataTablesInput();
    input.setStart(start);
    input.setLength(length);
    DataTablesOutput output = homePageService.findDataTablesOutput(input);
    assertThat(output.getRecordsTotal()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getRecordsFiltered()).isEqualTo(TOTAL_RISK_RECORDS);
    assertThat(output.getData().size()).isEqualTo(17);
    assertThat(output.getData().get(0).getNamedInsured()).startsWith(String.valueOf(start+1));
  }
}
