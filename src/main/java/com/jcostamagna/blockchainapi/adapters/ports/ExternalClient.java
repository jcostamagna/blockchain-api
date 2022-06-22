package com.jcostamagna.blockchainapi.adapters.ports;

import com.jcostamagna.blockchainapi.framework.ResponseInterpreter;
import com.jcostamagna.blockchainapi.usecases.GatewayResources;

public interface ExternalClient<T> {
  T resolve(GatewayResources gatewayResources, ResponseInterpreter<T> responseInterpreter);
}
