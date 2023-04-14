package com.java.test.msintegration.services.mapper;

import com.java.test.msintegration.dto.ConversionResponseDto;
import com.java.test.msintegration.dto.coinmarket.ConversionResultDto;
import com.java.test.msintegration.entities.ConversionEntity;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ConversionMapperService implements ConversionMapperServiceInterface {

  @Override
  public ConversionEntity mapToEntity(ConversionResultDto resultDto) {
    ConversionEntity entity = new ConversionEntity();
    entity.setRequestId(resultDto.getRequestId());
    entity.setSymbol(resultDto.getSymbol());
    entity.setAmount(BigDecimal.valueOf(resultDto.getAmount()));
    entity.setCurrency(resultDto.getCurrency());
    entity.setResult(BigDecimal.valueOf(resultDto.getResult()));

    return entity;
  }

  @Override
  public ConversionResponseDto mapToResult(ConversionEntity conversion) {
    return ConversionResponseDto.builder()
        .requestId(conversion.getRequestId())
        .symbol(conversion.getSymbol())
        .amount(conversion.getAmount().doubleValue())
        .currency(conversion.getCurrency())
        .equivalenceAmount(conversion.getResult().doubleValue())
        .build();
  }
}
