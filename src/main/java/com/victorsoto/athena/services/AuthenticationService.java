package com.victorsoto.athena.services;

import com.victorsoto.athena.entities.ApplicationUser;
import com.victorsoto.athena.repositories.UserRepository;
import com.victorsoto.athena.viewmodels.ServiceResponse;
import com.victorsoto.athena.viewmodels.UserRequest;
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
