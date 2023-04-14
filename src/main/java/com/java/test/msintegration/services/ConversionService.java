package com.java.test.msintegration.services;

import com.java.test.msintegration.components.coinmarket.CoinMarketClientServiceInterface;
import com.java.test.msintegration.components.messages.MessageServiceInterface;
import com.java.test.msintegration.dto.ConversionRequestDto;
import com.java.test.msintegration.dto.coinmarket.ConversionResultDto;
import com.java.test.msintegration.dto.coinmarket.Quote;
import com.java.test.msintegration.dto.coinmarket.ResponseData;
import com.java.test.msintegration.entities.ConversionEntity;
import com.java.test.msintegration.services.mapper.ConversionMapperServiceInterface;
import com.java.test.msintegration.services.repository.ConversionRepositoryServiceInterface;
import com.java.test.msintegration.services.response.ConversionResponseServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionService implements ConversionServiceInterface {

  private final MessageServiceInterface messageService;
  private final CoinMarketClientServiceInterface coinMarketClientService;
  private final ConversionRepositoryServiceInterface conversionRepositoryService;
  private final ConversionMapperServiceInterface conversionMapperService;
  private final ConversionResponseServiceInterface conversionResponseService;

  @Override
  public void convert(ConversionRequestDto requestDto) {
    log.info(messageService.getMessage("conversion.init.message"));

    var response = coinMarketClientService.callConvertCurrency(requestDto);
    if (response.getStatus().getError_code() != null) {}

    var responseDataOptional = response.getData().stream().findFirst();
    ConversionResultDto resultDto = null;
    if (responseDataOptional.isPresent()) {
      ResponseData responseData = responseDataOptional.get();
      Quote quote = responseData.getQuote().get(requestDto.getCurrency());

      resultDto =
          ConversionResultDto.builder()
              .requestId(requestDto.getRequestId())
              .symbol(requestDto.getSymbol())
              .amount(requestDto.getAmount())
              .currency(requestDto.getCurrency())
              .result(quote.getPrice())
              .build();
    }

    ConversionEntity conversionSaved =
        conversionRepositoryService.saveConversion(conversionMapperService.mapToEntity(resultDto));

    conversionResponseService.generateResponse(conversionSaved);

    log.info(messageService.getMessage("conversion.finished.message"));
  }
}
