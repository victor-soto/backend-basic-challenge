package com.victorsoto.accessmanagmentapi.viewmodels;

import com.victorsoto.accessmanagmentapi.config.enums.CurrencyEnum;
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
  private CurrencyEnum sourceCurrency;
  private CurrencyEnum targetCurrency;
  private BigDecimal rate;

}
