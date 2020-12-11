package com.victorsoto.accessmanagmentapi.viewmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse implements Serializable {

  private boolean success;
  private List<ServiceDetailResponse> details;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public List<ServiceDetailResponse> getDetails() {
    return details;
  }

  public void setDetails(List<ServiceDetailResponse> details) {
    this.details = details;
  }
}
