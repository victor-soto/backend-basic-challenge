package com.victorsoto.accessmanagmentapi.entities;

import com.victorsoto.accessmanagmentapi.config.enums.CurrencyEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(precision = 12, scale = 4)
  private BigDecimal rate;

  @Enumerated(EnumType.STRING)
  @Column(name = "source_currency")
  private CurrencyEnum sourceCurrency;

  @Enumerated(EnumType.STRING)
  @Column(name = "target_currency")
  private CurrencyEnum targetCurrency;

}
