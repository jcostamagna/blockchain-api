package com.jcostamagna.blockchainapi.adapters.controllers;

import com.jcostamagna.blockchainapi.domain.OrderBookAvg;
import com.jcostamagna.blockchainapi.usecases.OrderBookBlockchainService;
import com.jcostamagna.blockchainapi.usecases.out.OrderBooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchanges")
public class OrderBookController {

  @Autowired private OrderBookBlockchainService orderBookBlockchainService;

  @GetMapping(value = "/blockchain/order-books")
  public ResponseEntity<OrderBooksResponse> getAllOrderBooks() {
    return ResponseEntity.ok(orderBookBlockchainService.getAllOrderBooks());
  }

  @GetMapping(value = "/blockchain/order-books/{symbol}")
  public ResponseEntity<OrderBookAvg> getOrderBook(@PathVariable("symbol") String symbol) {
    return ResponseEntity.ok(orderBookBlockchainService.getOrderBook(symbol));
  }
}
