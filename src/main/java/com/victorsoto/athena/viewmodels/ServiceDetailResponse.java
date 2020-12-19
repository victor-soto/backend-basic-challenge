package com.victorsoto.athena.viewmodels;

import com.victorsoto.athena.config.enums.EnumServiceError;
import lombok.Data;

@Data
public class ServiceDetailResponse {

  private EnumServiceError error;
  private String description;

}
