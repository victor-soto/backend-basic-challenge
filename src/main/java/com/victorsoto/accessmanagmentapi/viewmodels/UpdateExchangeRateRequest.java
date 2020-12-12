package com.victorsoto.accessmanagmentapi.viewmodels;

import com.victorsoto.accessmanagmentapi.config.enums.CurrencyEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateExchangeRateRequest {

  private CurrencyEnum sourceCurrency;
  private CurrencyEnum targetCurrency;
  private BigDecimal rate;

}
