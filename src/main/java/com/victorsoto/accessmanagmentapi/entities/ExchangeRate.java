package com.victorsoto.accessmanagmentapi.entities;

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

  @Column(name = "source_currency")
  private String sourceCurrency;

  @Column(name = "target_currency")
  private String targetCurrency;

}
