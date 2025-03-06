package com.example.cryptobackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class TestingCryptoController {
  @Mock
  GetCryptoData mockGetCryptoData;
  @InjectMocks
  CryptoController cryptoController;

  public TestingCryptoController() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetCryptoPrice() throws Exception {
    CryptoData cryptoData = new CryptoData();
    cryptoData.setCurrency("70,223.99");

    when(mockGetCryptoData.getCryptoPrice("bitcoin", "gbp")).thenReturn(cryptoData);

    ResponseEntity<String> response = cryptoController.getCryptoPrice("bitcoin", "gbp");

    assertEquals("70,223.99", response.getBody());

  }

  
  @Test
  public void testGetEthereumPrice() throws Exception {
    CryptoData cryptoData = new CryptoData();
    cryptoData.setCurrency("1,775,29");

    when(mockGetCryptoData.getCryptoPrice("ethereum", "gbp")).thenReturn(cryptoData);

    ResponseEntity<String> response = cryptoController.getCryptoPrice("ethereum", "gbp");
    // ResponseEntity<String> response = cryptoController.getCryptoPrice("bitcoin", "gbp"); // crypto price is null

    assertEquals("1,775,29", response.getBody());

  }

}
