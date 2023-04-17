package com.java.test.msintegration.dto;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConversionRequestDtoTest {

  @Test
  public void testGettersAndSetters() {
    var symbol = "BTC";
    var amount = 1.0D;
    var currency = "USD";
    var requestId = UUID.randomUUID().toString();

    ConversionRequestDto conversionRequestDto =
        ConversionRequestDto.builder()
            .symbol(symbol)
            .amount(amount)
            .currency(currency)
            .requestId(requestId)
            .build();

    Assertions.assertEquals(symbol, conversionRequestDto.getSymbol());
    Assertions.assertEquals(amount, conversionRequestDto.getAmount());
    Assertions.assertEquals(currency, conversionRequestDto.getCurrency());
    Assertions.assertEquals(requestId, conversionRequestDto.getRequestId());
  }
}
