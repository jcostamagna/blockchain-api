package com.jcostamagna.blockchainapi.domain;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SymbolCollection {
  HashMap<String, Object> symbols;
}
