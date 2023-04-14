package com.java.test.msintegration.dto.coinmarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionResultDto {

  // from
  private String requestId;
  private String symbol;
  private Double amount;

  // from
  private String currency;
  private Double result;
}
