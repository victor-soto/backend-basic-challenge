package com.victorsoto.athena.services;

import com.victorsoto.athena.viewmodels.*;
import io.reactivex.Single;

import java.util.List;

public interface IExchangeRateService {

  Single<ExchangeRateResponse> calculate(ExchangeRateRequest request);

  Single<UpdateExchangeRateResponse> update(UpdateExchangeRateRequest request);

  Single<List<CreateExchangeRateResponse>> create(List<CreateExchangeRateRequest> requestList);

  Single<List<CreateExchangeRateResponse>> all();
}
