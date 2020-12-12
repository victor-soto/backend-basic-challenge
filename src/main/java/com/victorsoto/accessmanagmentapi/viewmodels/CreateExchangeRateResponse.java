package com.victorsoto.accessmanagmentapi.viewmodels;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateExchangeRateResponse {

  private long id;
  private String sourceCurrency;
  private String targetCurrency;
  private BigDecimal rate;

}
