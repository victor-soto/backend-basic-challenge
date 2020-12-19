package com.victorsoto.athena.viewmodels;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse implements Serializable {

  private boolean success;
  private List<ServiceDetailResponse> details;

}
