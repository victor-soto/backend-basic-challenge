package com.victorsoto.accessmanagmentapi.web;

import com.victorsoto.accessmanagmentapi.services.IAuthenticationService;
import com.victorsoto.accessmanagmentapi.viewmodels.ServiceResponse;
import com.victorsoto.accessmanagmentapi.viewmodels.UserRequest;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

  private final IAuthenticationService authenticationService;

  @PostMapping(value = "/sign-up", produces = MediaType.APPLICATION_JSON_VALUE)
  public Single<ServiceResponse> signUp(@RequestBody UserRequest request) {
    return authenticationService.signUp(request);
  }

}
