package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.viewmodels.ExchangeRateRequest;
import com.victorsoto.accessmanagmentapi.viewmodels.ExchangeRateResponse;
import io.reactivex.Single;

public interface IExchangeRateService {

  Single<ExchangeRateResponse> calculate(ExchangeRateRequest request);

}
