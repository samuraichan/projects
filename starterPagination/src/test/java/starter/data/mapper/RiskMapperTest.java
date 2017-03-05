package starter.data.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import starter.data.model.RiskStatus;
import starter.data.model.SearchFilter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class RiskMapperTest {
  
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
}
