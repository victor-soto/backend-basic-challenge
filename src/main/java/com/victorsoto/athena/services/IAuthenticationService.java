package com.victorsoto.athena.services;

import com.victorsoto.athena.viewmodels.ServiceResponse;
import com.victorsoto.athena.viewmodels.UserRequest;
import io.reactivex.Single;

public interface IAuthenticationService {

  Single<ServiceResponse> signUp(UserRequest request);

}
