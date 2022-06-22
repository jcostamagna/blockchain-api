package com.jcostamagna.blockchainapi.framework.gateways;

import com.jcostamagna.blockchainapi.usecases.GatewayResources;

public class OrderBookResources implements GatewayResources {
  private final String symbol;

  public OrderBookResources(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String getUrlPath() {
    return "https://api.blockchain.com/v3/exchange/l3/" + symbol;
  }
}
