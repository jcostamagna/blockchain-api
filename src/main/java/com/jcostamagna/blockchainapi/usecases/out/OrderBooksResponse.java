package com.jcostamagna.blockchainapi.usecases.out;

import com.jcostamagna.blockchainapi.domain.OrderBookAvg;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderBooksResponse {
  List<OrderBookAvg> orderBookAvg;
}
