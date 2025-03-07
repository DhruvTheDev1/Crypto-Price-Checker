package com.example.cryptobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CryptoController {
  private GetCryptoData getCryptoData;

  @Autowired
  public CryptoController(GetCryptoData getCryptoData) {
    this.getCryptoData = getCryptoData;
  }

  // request cryptoId, currency
  @GetMapping("/CryptoPrice")
  public ResponseEntity<String> getCryptoPrice(@RequestParam String cryptoId, @RequestParam String currency)
      throws Exception {

    try {
      CryptoData cryptoPrice = getCryptoData.getCryptoPrice(cryptoId, currency);
      return ResponseEntity.ok(cryptoPrice.getCurrency()); // sends price

    } catch (Exception e) {
      return new ResponseEntity<String>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
}
