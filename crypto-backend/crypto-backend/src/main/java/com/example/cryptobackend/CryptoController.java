package com.example.cryptobackend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// testing on localhost 8080
@RestController
public class CryptoController {
  private GetCryptoData getCryptoData;

  public CryptoController() {
    this.getCryptoData = new GetCryptoData();
  }

  @GetMapping("/checkCryptoPrice")
   public ResponseEntity<Map<String, Object>> getCryptoPrice(
        @RequestParam String cryptoName, 
        @RequestParam String cryptoCurrency
    ) throws Exception {
        CryptoData cryptoData = getCryptoData.getCryptoPrice(cryptoName, cryptoCurrency);

        Map<String, Object> response = new HashMap<>();
        response.put("price", cryptoData.getCurrency()); 

        return ResponseEntity.ok(response);
    }
}
