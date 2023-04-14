package com.java.test.msintegration.repositories;

import com.java.test.msintegration.entities.ConversionEntity;

import java.util.Optional;

public interface ConversionRepositoryInterface {
  ConversionEntity save(ConversionEntity conversionEntity);

  Optional<ConversionEntity> findById(Long id);

  Optional<ConversionEntity> findBySymbol(String symbol);
}
