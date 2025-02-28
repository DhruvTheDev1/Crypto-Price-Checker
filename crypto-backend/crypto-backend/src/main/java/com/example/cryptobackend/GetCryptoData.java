package com.example.cryptobackend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetCryptoData {

  //testing getCryptoPrice
public static void main(String[] args) throws Exception {
  GetCryptoData fetchDataTest = new GetCryptoData();

  String id = "bitcoin";
  String currency = "gbp";

  CryptoData test = fetchDataTest.getCryptoPrice(id, currency);
  System.out.println(test.getCryptoId());
  System.out.println(test.getCurrency());


}
  public CryptoData getCryptoPrice(String cryptoId, String vs_currencies) throws Exception {

    HttpRequest getRequest = HttpRequest.newBuilder()
        .uri(new URI(
            ""))
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();

    HttpClient httpClient = HttpClient.newHttpClient();

    HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

    // testing = prints json response
    // System.out.println(response.body());

    return parseResponse(response.body(), cryptoId, vs_currencies);

  }

  public CryptoData parseResponse(String responseBody, String cryptoId, String vs_currencies) throws Exception {

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNodeRoot = objectMapper.readTree(responseBody);

    JsonNode currencyPrice = jsonNodeRoot.get(cryptoId);
    String price = currencyPrice.get(vs_currencies).asText();

    CryptoData cryptoData = new CryptoData();
    cryptoData.setCryptoId(cryptoId);
    cryptoData.setCurrency(price);

    return cryptoData;

  }
}
