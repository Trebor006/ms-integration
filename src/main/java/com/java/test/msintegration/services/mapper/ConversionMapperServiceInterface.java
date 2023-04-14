package com.java.test.msintegration.services.mapper;

import com.java.test.msintegration.dto.ConversionResponseDto;
import com.java.test.msintegration.dto.coinmarket.ConversionResultDto;
import com.java.test.msintegration.entities.ConversionEntity;

public interface ConversionMapperServiceInterface {
  ConversionEntity mapToEntity(ConversionResultDto resultDto);

  ConversionResponseDto mapToResult(ConversionEntity conversion);
}
