package com.victorsoto.athena.web;

import com.victorsoto.athena.services.IExchangeRateService;
import com.victorsoto.athena.viewmodels.*;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public Single<List<CreateExchangeRateResponse>> create(@RequestBody List<CreateExchangeRateRequest> requestList) {

    return service.create(requestList);
  }

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public Single<List<CreateExchangeRateResponse>> all() {

    return service.all();
  }


}
