package com.java.test.msintegration.services.repository;

import com.java.test.msintegration.entities.ConversionEntity;
import com.java.test.msintegration.repositories.ConversionRepositoryInterface;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConversionRepositoryService implements ConversionRepositoryServiceInterface {

  private final ConversionRepositoryInterface conversionRepository;

  @Override
  @Transactional
  public ConversionEntity saveConversion(ConversionEntity conversion) {
    return conversionRepository.save(conversion);
  }

  @Override
  public Optional<ConversionEntity> getConversionById(Long id) {
    return conversionRepository.findById(id);
  }

  @Override
  public Optional<ConversionEntity> getConversionBySymbol(String symbol) {
    return conversionRepository.findBySymbol(symbol);
  }
}
