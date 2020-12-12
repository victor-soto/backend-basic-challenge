package com.victorsoto.accessmanagmentapi.viewmodels;

import com.victorsoto.accessmanagmentapi.config.enums.CurrencyEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UpdateExchangeRateResponse {

  private long id;
  private CurrencyEnum sourceCurrency;
  private CurrencyEnum targetCurrency;
  private BigDecimal rate;

}
