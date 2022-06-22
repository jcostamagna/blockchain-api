package com.jcostamagna.blockchainapi.adapters.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseError {
  private final String error;
  private final String message;
  private final int status;
}
