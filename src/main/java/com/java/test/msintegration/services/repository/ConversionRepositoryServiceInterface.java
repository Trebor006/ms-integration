package com.java.test.msintegration.services.repository;

import com.java.test.msintegration.entities.ConversionEntity;
import java.util.Optional;

public interface ConversionRepositoryServiceInterface {

  ConversionEntity saveConversion(ConversionEntity conversion);
//  void deleteConversionById(Long id);

//  List<ConversionEntity> getAllConversions();
//
  Optional<ConversionEntity> getConversionById(Long id);

  Optional<ConversionEntity> getConversionBySymbol(String symbol);

}
