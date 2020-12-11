package com.victorsoto.accessmanagmentapi.viewmodels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

  private String username;
  private String password;

}
