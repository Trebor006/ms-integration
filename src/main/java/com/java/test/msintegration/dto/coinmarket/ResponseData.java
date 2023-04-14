package com.java.test.msintegration.dto.coinmarket;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

  private Integer id;
  private String symbol;
  private String name;
  private Double amount;

  //    @JsonProperty("last_updated")
  //    private String lastUpdated;
  private String last_updated;

  private Map<String, Quote> quote;
}
