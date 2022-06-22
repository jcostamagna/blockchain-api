package com.jcostamagna.blockchainapi.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcostamagna.blockchainapi.domain.SymbolCollection;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ResponseInterpreterImpl implements ResponseInterpreter<SymbolCollection> {

  ObjectMapper mapper = new ObjectMapper();

  @Override
  public SymbolCollection interpret(InputStream inputStream) {
    try {
      HashMap symbols = mapper.readValue(inputStream, HashMap.class);
      return new SymbolCollection(symbols);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new SymbolCollection(new HashMap<>());
  }
}
