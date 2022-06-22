package com.jcostamagna.blockchainapi.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcostamagna.blockchainapi.adapters.exceptions.BadRequestException;
import com.jcostamagna.blockchainapi.domain.OrderBook;
import java.io.IOException;
import java.io.InputStream;

public class ResponseInterpreterOrderBookImpl implements ResponseInterpreter<OrderBook> {

  ObjectMapper mapper = new ObjectMapper();

  @Override
  public OrderBook interpret(InputStream inputStream) {
    try {
      return mapper.readValue(inputStream, OrderBook.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw new BadRequestException(
          "There was an error while processing Order Book, may be it does not exist");
    }
  }
}
