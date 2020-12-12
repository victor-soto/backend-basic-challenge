package com.victorsoto.accessmanagmentapi.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {

  private BigDecimal amount;
  private BigDecimal convertedAmount;
  private String sourceCurrency;
  private String targetCurrency;
  private BigDecimal rate;

}
