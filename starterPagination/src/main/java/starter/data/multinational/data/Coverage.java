package starter.data.multinational.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Coverage {
  
  @JacksonXmlProperty(localName = "CurrencyCode")
  private String currencyCode;
  
  @JacksonXmlProperty(localName = "CurrencyName")
  private String currencyName;

  @JacksonXmlProperty(localName = "CurrencyId")
  private Integer currencyId;

  @JacksonXmlProperty(localName = "PolicyEffectiveDate")
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.S")
  private Date policyEffectiveDate;
  
  @JacksonXmlProperty(localName = "PolicyExpirationDate")
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.S")
  private String policyExpirationDate;

  @JacksonXmlProperty(localName = "TransactionType")
  private String transactionType;

  @JacksonXmlProperty(localName = "ExRateConv")
  private Double exRateConv;

  @JacksonXmlProperty(localName = "ExRate")
  private Double exRate;
  
  @JacksonXmlProperty(localName = "Type")
  private Type[] type;

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public Integer getCurrencyId() {
    return currencyId;
  }

  public void setCurrencyId(Integer currencyId) {
    this.currencyId = currencyId;
  }

  public Date getPolicyEffectiveDate() {
    return policyEffectiveDate;
  }

  public void setPolicyEffectiveDate(Date policyEffectiveDate) {
    this.policyEffectiveDate = policyEffectiveDate;
  }

  public String getPolicyExpirationDate() {
    return policyExpirationDate;
  }

  public void setPolicyExpirationDate(String policyExpirationDate) {
    this.policyExpirationDate = policyExpirationDate;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public Double getExRateConv() {
    return exRateConv;
  }

  public void setExRateConv(Double exRateConv) {
    this.exRateConv = exRateConv;
  }

  public Double getExRate() {
    return exRate;
  }

  public void setExRate(Double exRate) {
    this.exRate = exRate;
  }

  public Type[] getType() {
    return type;
  }

  public void setType(Type[] type) {
    this.type = type;
  }
}
