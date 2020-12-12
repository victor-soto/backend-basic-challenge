package com.victorsoto.accessmanagmentapi.viewmodels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BearerTokenResponse {

  private String bearerToken;
  private long expiration;

}
