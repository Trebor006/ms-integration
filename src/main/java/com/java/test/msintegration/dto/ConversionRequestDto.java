package com.java.test.msintegration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRequestDto {

  private String requestId;
  private String symbol;
  private String currency;
  private Double amount;
}
