package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.repositories.ExchangeRateRepository;
import com.victorsoto.accessmanagmentapi.viewmodels.ExchangeRateRequest;
import com.victorsoto.accessmanagmentapi.viewmodels.ExchangeRateResponse;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeRateService implements IExchangeRateService {

  private final ExchangeRateRepository repository;

  @Override
  public Single<ExchangeRateResponse> calculate(ExchangeRateRequest request) {

    return Single.fromCallable(() -> {
      var exchangeRate = repository.findBySourceAndTargetAmount(request.getSourceCurrency(), request.getTargetCurrency())
          .orElseThrow(() -> new NullPointerException("No se encontró información del tipo de cambio"));

      return ExchangeRateResponse.builder()
          .amount(request.getAmount())
          .convertedAmount(request.getAmount().multiply(exchangeRate.getRate()))
          .sourceCurrency(exchangeRate.getSourceCurrency())
          .targetCurrency(exchangeRate.getTargetCurrency())
          .rate(exchangeRate.getRate().compareTo(BigDecimal.ONE) >= 1 ? exchangeRate.getRate() : exchangeRate.getRate().multiply(BigDecimal.valueOf(10)))
          .build();
    });
  }

}
