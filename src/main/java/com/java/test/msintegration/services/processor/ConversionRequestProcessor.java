package com.java.test.msintegration.services.processor;

import com.google.gson.Gson;
import com.java.test.msintegration.dto.ConversionRequestDto;
import com.java.test.msintegration.services.ConversionServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionRequestProcessor implements Processor {

  private final ConversionServiceInterface conversionService;

  @Override
  public void process(String content) {
    log.info("process started");
    Gson gson = new Gson();
    var conversionRequestDto = gson.fromJson(content, ConversionRequestDto.class);
    conversionService.convert(conversionRequestDto);
    log.info("process finished");
  }
}
