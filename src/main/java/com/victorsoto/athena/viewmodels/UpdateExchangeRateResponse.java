package com.victorsoto.athena.viewmodels;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateExchangeRateResponse {

  private long id;
  private String sourceCurrency;
  private String targetCurrency;
  private BigDecimal rate;

}
