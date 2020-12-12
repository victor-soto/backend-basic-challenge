package com.victorsoto.accessmanagmentapi.viewmodels;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateExchangeRateRequest {

  private String sourceCurrency;
  private String targetCurrency;
  private BigDecimal rate;

}
