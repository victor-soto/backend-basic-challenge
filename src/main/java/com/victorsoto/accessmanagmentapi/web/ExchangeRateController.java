package com.victorsoto.accessmanagmentapi.web;

import com.victorsoto.accessmanagmentapi.services.IExchangeRateService;
import com.victorsoto.accessmanagmentapi.viewmodels.*;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

  private final IExchangeRateService service;

  @PostMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
  public Single<ExchangeRateResponse> calculate(@RequestBody ExchangeRateRequest request) {

    return service.calculate(request);
  }

  @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
  public Single<UpdateExchangeRateResponse> update(@RequestBody UpdateExchangeRateRequest request) {

    return service.update(request);
  }


}
