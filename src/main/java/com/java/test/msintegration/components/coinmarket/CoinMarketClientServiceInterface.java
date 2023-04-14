package com.java.test.msintegration.components.coinmarket;

import com.java.test.msintegration.dto.ConversionRequestDto;
import com.java.test.msintegration.dto.coinmarket.Response;

public interface CoinMarketClientServiceInterface {
  Response callConvertCurrency(ConversionRequestDto conversionRequestDto);
}
