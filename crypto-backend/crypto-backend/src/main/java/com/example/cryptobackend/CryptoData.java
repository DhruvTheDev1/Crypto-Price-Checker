package com.example.cryptobackend;

// POJO for storing cryptoId and currency
// currency will be returned to frontend
public class CryptoData {
  private String cryptoId; // crypto coins id - CoinGeckoAPI
  private String currency; // target currency - also price of cryto

  public String getCryptoId() {
    return cryptoId;
  }

  public void setCryptoId(String cryptoId) {
    this.cryptoId = cryptoId;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

}
