package com.victorsoto.accessmanagmentapi.viewmodels;

import com.victorsoto.accessmanagmentapi.config.enums.EnumServiceError;
import lombok.Data;

@Data
public class ServiceDetailResponse {

  private EnumServiceError error;
  private String description;

}
