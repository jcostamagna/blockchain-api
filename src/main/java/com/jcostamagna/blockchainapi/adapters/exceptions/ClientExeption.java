package com.jcostamagna.blockchainapi.adapters.exceptions;

public class ClientExeption extends RuntimeException {
  public ClientExeption(String content) {
    super("There was an error with client: " + content);
  }
}
