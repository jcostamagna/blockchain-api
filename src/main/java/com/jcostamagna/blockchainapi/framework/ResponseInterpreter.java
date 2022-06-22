package com.jcostamagna.blockchainapi.framework;

import java.io.InputStream;

public interface ResponseInterpreter<T> {
  T interpret(InputStream httpResponse);
}
