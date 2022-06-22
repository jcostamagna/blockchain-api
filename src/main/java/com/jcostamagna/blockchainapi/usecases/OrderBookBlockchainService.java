package com.jcostamagna.blockchainapi.usecases;

import com.jcostamagna.blockchainapi.domain.*;
import com.jcostamagna.blockchainapi.usecases.out.OrderBooksResponse;
import com.jcostamagna.blockchainapi.usecases.ports.OrderBookProvider;
import com.jcostamagna.blockchainapi.usecases.ports.SymbolsProvider;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookBlockchainService {

  @Autowired SymbolsProvider symbolsProvider;

  @Autowired OrderBookProvider orderBookProvider;

  public OrderBooksResponse getAllOrderBooks() {

    SymbolCollection symbolCollection = symbolsProvider.getAllSymbols();

    List<OrderBookAvg> orderBooks =
        symbolCollection.getSymbols().keySet().parallelStream()
            .map(symbol -> getOrderBook(symbol))
            .collect(Collectors.toList());

    return new OrderBooksResponse(orderBooks);
  }

  public OrderBookAvg getOrderBook(String symbol) {
    OrderBook orderBook = orderBookProvider.getOrderBook(symbol);

    Double bidPriceAvg =
        orderBook.getBids().stream().mapToDouble(Offer::getPx).average().orElse(0.0);
    Double bidQuantityAvg =
        orderBook.getBids().stream().mapToDouble(Offer::getQty).average().orElse(0.0);
    Double askPriceAvg =
        orderBook.getAsks().stream().mapToDouble(Offer::getPx).average().orElse(0.0);
    Double askQuantityAvg =
        orderBook.getAsks().stream().mapToDouble(Offer::getQty).average().orElse(0.0);

    return new OrderBookAvg(
        symbol, new Average(bidPriceAvg, bidQuantityAvg), new Average(askPriceAvg, askQuantityAvg));
  }
}
