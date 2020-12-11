package com.victorsoto.accessmanagmentapi.services;

import com.victorsoto.accessmanagmentapi.viewmodels.ServiceResponse;
import com.victorsoto.accessmanagmentapi.viewmodels.UserRequest;
import io.reactivex.Single;

public interface IAuthenticationService {

  Single<ServiceResponse> signUp(UserRequest request);

}
