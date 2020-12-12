package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.viewmodels.ExchangeRateRequest;
import com.victorsoto.accessmanagmentapi.viewmodels.ExchangeRateResponse;
import com.victorsoto.accessmanagmentapi.viewmodels.UpdateExchangeRateRequest;
import com.victorsoto.accessmanagmentapi.viewmodels.UpdateExchangeRateResponse;
import io.reactivex.Single;

public interface IExchangeRateService {

  Single<ExchangeRateResponse> calculate(ExchangeRateRequest request);

  Single<UpdateExchangeRateResponse> update(UpdateExchangeRateRequest request);
}
