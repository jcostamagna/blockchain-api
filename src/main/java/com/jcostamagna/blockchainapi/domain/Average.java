package com.jcostamagna.blockchainapi.domain;

import lombok.Data;

@Data
public class Average {
  private final Double priceAverage;
  private final Double quantityAverage;
}
