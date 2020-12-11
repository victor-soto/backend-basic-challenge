package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.entities.ApplicationUser;
import com.victorsoto.accessmanagmentapi.repositories.UserRepository;
import com.victorsoto.accessmanagmentapi.viewmodels.ServiceResponse;
import com.victorsoto.accessmanagmentapi.viewmodels.UserRequest;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  @Override
  public Single<ServiceResponse> signUp(UserRequest request) {
    var applicationUser = userRepository.save(ApplicationUser.builder().password(bCryptPasswordEncoder.encode(request.getPassword())).username(request.getUsername()).build());
    var response = new ServiceResponse(applicationUser.getId() != 0L, new ArrayList<>());
    return Single.just(response);
  }
}
