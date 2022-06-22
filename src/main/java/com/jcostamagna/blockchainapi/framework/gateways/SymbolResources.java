package com.jcostamagna.blockchainapi.framework.gateways;

import com.jcostamagna.blockchainapi.usecases.GatewayResources;

public class SymbolResources implements GatewayResources {
  @Override
  public String getUrlPath() {
    return "https://api.blockchain.com/v3/exchange/symbols";
  }
}
