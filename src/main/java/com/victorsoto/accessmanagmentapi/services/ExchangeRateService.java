package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.entities.ExchangeRate;
import com.victorsoto.accessmanagmentapi.repositories.ExchangeRateRepository;
import com.victorsoto.accessmanagmentapi.viewmodels.*;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

  @Override
  public Single<UpdateExchangeRateResponse> update(UpdateExchangeRateRequest request) {

    return Single.fromCallable(() -> {
      var exchangeRate = repository.findBySourceAndTargetAmount(request.getSourceCurrency(), request.getTargetCurrency())
          .orElseThrow(() -> new NullPointerException("No se encontró información del tipo de cambio"));
      exchangeRate.setRate(request.getRate());

      var savedExchangeRate = repository.save(exchangeRate);

      return UpdateExchangeRateResponse.builder()
          .id(savedExchangeRate.getId())
          .sourceCurrency(savedExchangeRate.getSourceCurrency())
          .targetCurrency(savedExchangeRate.getTargetCurrency())
          .rate(savedExchangeRate.getRate())
          .build();
    });
  }

  @Override
  public Single<List<CreateExchangeRateResponse>> create(List<CreateExchangeRateRequest> requestList) {

    return Single.fromCallable(() -> requestList.stream().map(request ->
        repository.save(ExchangeRate.builder()
            .sourceCurrency(request.getSourceCurrency())
            .targetCurrency(request.getTargetCurrency())
            .rate(request.getRate()).build()))
        .map(savedExchangeRate ->
            CreateExchangeRateResponse
                .builder()
                .id(savedExchangeRate.getId())
                .sourceCurrency(savedExchangeRate.getSourceCurrency())
                .targetCurrency(savedExchangeRate.getTargetCurrency())
                .rate(savedExchangeRate.getRate())
                .build()
        ).collect(Collectors.toList()));
  }

  @Override
  public Single<List<CreateExchangeRateResponse>> all() {

    return Single.fromCallable(() -> repository.findAll().stream().map(exchangeRate -> CreateExchangeRateResponse
        .builder().id(exchangeRate.getId())
        .sourceCurrency(exchangeRate.getSourceCurrency())
        .targetCurrency(exchangeRate.getTargetCurrency())
        .rate(exchangeRate.getRate()).build()).collect(Collectors.toList()));
  }

}
