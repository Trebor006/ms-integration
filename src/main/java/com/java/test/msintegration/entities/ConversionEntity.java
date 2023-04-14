package com.java.test.msintegration.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "conversions")
public class ConversionEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conversions_id_seq")
  @SequenceGenerator(
      name = "conversions_id_seq",
      sequenceName = "conversions_id_seq",
      allocationSize = 1)
  private Long id;

  @Column(name = "request_id", nullable = false, unique = true)
  private String requestId;

  @Column(name = "symbol", nullable = false)
  private String symbol;

  @Column(name = "amount", nullable = false)
  private BigDecimal amount;

  @Column(name = "currency", nullable = false)
  private String currency;

  @Column(name = "result", nullable = false)
  private BigDecimal result;

  @Column(
      name = "created_at",
      nullable = false,
      updatable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createdAt;

  @Column(
      name = "updated_at",
      nullable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime updatedAt;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
    updatedAt = createdAt;
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
