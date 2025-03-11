package com.example.cryptobackend;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GetCryptoData {
@Value("${api.url}")
private String apiUrl;

  public CryptoData getCryptoPrice(String cryptoId, String currency) throws Exception {

    String url = apiUrl.replace("{cryptoId}", cryptoId).replace("{currency}", currency);

    HttpRequest getRequest = HttpRequest.newBuilder()
    .uri(new URI(url))
    .GET()
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
