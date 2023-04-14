package com.java.test.msintegration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionResponseDto {

  private String requestId;
  private String symbol;
  private Double amount;
  private String currency;
  private Double equivalenceAmount;
}
