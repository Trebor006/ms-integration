package com.java.test.msintegration.dto.coinmarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {

  private String timestamp; // 2018-06-06T07:52:27.273Z

  //    @JsonProperty("error_code")
  //    private Integer errorCode;
  private Integer error_code;

  //    @JsonProperty("error_message")
  //    private String errorMessage;
  private String error_message;
  private String elapsed;

  //    @JsonProperty("credit_count")
  //    private String creditCount;
  private String credit_count;
}
