package com.example.cryptobackend;
// POJO for storying cryptoId and currency
// stores from coingecko api
// currency will be returned to frontend
public class CryptoData {
  private String cryptoId; // testing use
  private String currency;

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
