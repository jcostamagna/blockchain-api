package com.jcostamagna.blockchainapi.usecases.ports;

import com.jcostamagna.blockchainapi.domain.OrderBook;

public interface OrderBookProvider {
  OrderBook getOrderBook(String symbol);
}
