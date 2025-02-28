package com.example.cryptobackend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetCryptoData {

  // test method
  // testing getcrypto price
  // CoinGecko API - get coin price by id
  public static void main(String[] args) throws Exception {
    GetCryptoData fetchDataTest = new GetCryptoData();

    String id = "bitcoin";
    String currency = "gbp";

    CryptoData test = fetchDataTest.getCryptoPrice(id, currency);
    System.out.println(test.getCryptoId());
    System.out.println(test.getCurrency());
  }

  // calls CoinGecko API - Coin Price by IDs
  // cryptoId - id of crypto coin, currency - also price of crypto coin
  public CryptoData getCryptoPrice(String cryptoId, String currency) throws Exception {

    HttpRequest getRequest = HttpRequest.newBuilder()
        .uri(new URI(
            "" + currency))
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();

    HttpClient httpClient = HttpClient.newHttpClient();
    HttpResponse<String> response = httpClient.send(getRequest,
        HttpResponse.BodyHandlers.ofString());

    // System.out.println(response.body()); // test json print

    return parseResponse(response.body(), cryptoId, currency);

  }

  public CryptoData parseResponse(String responseBody, String cryptoId, String currency) throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode JsonNodeRoot = objectMapper.readTree(responseBody);
     
    JsonNode currencyPrice = JsonNodeRoot.get(cryptoId); // gets currency of crypto coin
    String price = currencyPrice.get(currency).asText(); 

    CryptoData cryptoData = new CryptoData();
    cryptoData.setCryptoId(cryptoId);
    cryptoData.setCurrency(price);

    return cryptoData; // returns crypto id and currency 

  }

}
