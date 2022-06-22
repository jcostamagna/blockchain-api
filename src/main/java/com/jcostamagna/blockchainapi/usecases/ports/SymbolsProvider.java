package com.jcostamagna.blockchainapi.usecases.ports;

import com.jcostamagna.blockchainapi.domain.SymbolCollection;

public interface SymbolsProvider {
  SymbolCollection getAllSymbols();
}
