package starter.data.entity;

import java.math.BigDecimal;
import java.util.Collection;

public class Account {

  private Integer number;
  
  private BigDecimal balance;
  
  private Collection<AccountHolder> accountHolders;
}
