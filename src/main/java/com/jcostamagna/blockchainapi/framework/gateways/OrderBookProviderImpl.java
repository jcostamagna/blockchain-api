package com.jcostamagna.blockchainapi.framework.gateways;

import com.jcostamagna.blockchainapi.adapters.ports.ExternalClient;
import com.jcostamagna.blockchainapi.domain.OrderBook;
import com.jcostamagna.blockchainapi.framework.ResponseInterpreter;
import com.jcostamagna.blockchainapi.framework.ResponseInterpreterOrderBookImpl;
import com.jcostamagna.blockchainapi.usecases.GatewayResources;
import com.jcostamagna.blockchainapi.usecases.ports.OrderBookProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderBookProviderImpl implements OrderBookProvider {

  @Autowired ExternalClient<OrderBook> externalClient;

  ResponseInterpreter<OrderBook> orderBookResponseInterpreter =
      new ResponseInterpreterOrderBookImpl();

  @Override
  public OrderBook getOrderBook(String symbol) {

    GatewayResources gatewayResources = new OrderBookResources(symbol);

    OrderBook orderBook = externalClient.resolve(gatewayResources, orderBookResponseInterpreter);

    return orderBook;
  }
}
