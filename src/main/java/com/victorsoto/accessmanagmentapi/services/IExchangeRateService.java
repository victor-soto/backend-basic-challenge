package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.viewmodels.*;
import io.reactivex.Single;

import java.util.List;

public interface IExchangeRateService {

  Single<ExchangeRateResponse> calculate(ExchangeRateRequest request);

  Single<UpdateExchangeRateResponse> update(UpdateExchangeRateRequest request);

  Single<List<CreateExchangeRateResponse>> create(List<CreateExchangeRateRequest> requestList);

  Single<List<CreateExchangeRateResponse>> all();
}
