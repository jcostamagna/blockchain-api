package com.jcostamagna.blockchainapi.domain;

import lombok.Data;

@Data
public class OrderBookAvg {
  private final String symbol;
  private final Average bids;
  private final Average asks;
}
