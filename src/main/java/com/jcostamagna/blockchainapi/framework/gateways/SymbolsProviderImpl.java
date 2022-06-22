package com.jcostamagna.blockchainapi.framework.gateways;

import com.jcostamagna.blockchainapi.adapters.ports.ExternalClient;
import com.jcostamagna.blockchainapi.domain.SymbolCollection;
import com.jcostamagna.blockchainapi.framework.ResponseInterpreter;
import com.jcostamagna.blockchainapi.framework.ResponseInterpreterImpl;
import com.jcostamagna.blockchainapi.usecases.GatewayResources;
import com.jcostamagna.blockchainapi.usecases.ports.SymbolsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SymbolsProviderImpl implements SymbolsProvider {

  @Autowired ExternalClient<SymbolCollection> externalClient;

  ResponseInterpreter<SymbolCollection> symbolCollectionResponseInterpreter =
      new ResponseInterpreterImpl();

  GatewayResources gatewayResources = new SymbolResources();

  @Override
  public SymbolCollection getAllSymbols() {

    SymbolCollection symbolCollection =
        externalClient.resolve(gatewayResources, symbolCollectionResponseInterpreter);

    return symbolCollection;
  }
}
