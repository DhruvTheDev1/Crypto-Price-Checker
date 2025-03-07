package com.example.cryptobackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestingCryptoService {
  @Mock
  HttpResponse<String> mockResponse;
  @InjectMocks
  GetCryptoData getCryptoData;

  public TestingCryptoService() {
    MockitoAnnotations.openMocks(this);
  }

  // testing parseResponse method
  // checking if correct values are extracted from JSON
  // coingecko response - {"bitcoin":{"gbp":68571}}
  @Test
  public void parseResponseTest() throws Exception {
    String jsonResponse = "{\"bitcoin\": {\"gbp\": \"68571\"}}";

    when(mockResponse.body()).thenReturn(jsonResponse);
    when(mockResponse.statusCode()).thenReturn(200);

    CryptoData test = getCryptoData.parseResponse(jsonResponse, "bitcoin", "gbp");

    assertEquals("68571", test.getCurrency());
    assertEquals("bitcoin", test.getCryptoId());
  }
}
