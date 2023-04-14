package com.java.test.msintegration.repositories;

import com.java.test.msintegration.entities.ConversionEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ConversionRepository implements ConversionRepositoryInterface {

  @PersistenceContext private EntityManager entityManager;

  @Override
  public ConversionEntity save(ConversionEntity conversionEntity) {
    entityManager.persist(conversionEntity);
    return conversionEntity;
  }

  @Override
  public Optional<ConversionEntity> findById(Long id) {
    return Optional.ofNullable(entityManager.find(ConversionEntity.class, id));
  }

  @Override
  public Optional<ConversionEntity> findBySymbol(String symbol) {
    return entityManager
        .createQuery(
            "SELECT ce " + "FROM ConversionEntity ce " + "WHERE ce.symbol = :symbol",
            ConversionEntity.class)
        .setParameter("symbol", symbol)
        .getResultList()
        .stream()
        .findFirst();
  }
}
