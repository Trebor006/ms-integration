package com.java.test.msintegration.dto.coinmarket;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

  private List<ResponseData> data;
  private ResponseStatus status;
}
