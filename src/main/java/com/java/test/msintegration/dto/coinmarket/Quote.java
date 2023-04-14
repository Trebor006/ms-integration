package com.java.test.msintegration.dto.coinmarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

  private Double price;

  //    @JsonProperty("last_updated")
  //    private String lastUpdated;
  private String last_updated;
}
