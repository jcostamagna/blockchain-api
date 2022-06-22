package com.jcostamagna.blockchainapi.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBook {
  String symbol;
  List<Offer> bids;
  List<Offer> asks;
}
