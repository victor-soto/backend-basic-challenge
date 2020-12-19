package com.victorsoto.athena.viewmodels;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExchangeRateRequest {

  private BigDecimal amount;
  private String sourceCurrency;
  private String targetCurrency;

}
