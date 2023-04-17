package com.java.test.msintegration.services.processor;

import static org.mockito.Mockito.when;

import com.google.gson.Gson;
import com.java.test.msintegration.components.messages.MessageServiceInterface;
import com.java.test.msintegration.dto.ConversionRequestDto;
import com.java.test.msintegration.services.ConversionServiceInterface;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConversionRequestProcessorTest {
  @Mock private MessageServiceInterface messageService;
  @Mock private ConversionServiceInterface conversionService;

  @InjectMocks private ConversionRequestProcessor conversionRequestProcessor;

  @Test
  public void testProcess() {
    ConversionRequestDto conversionRequestDto =
        ConversionRequestDto.builder()
            .symbol("BTC")
            .amount(1D)
            .currency("USD")
            .requestId(UUID.randomUUID().toString())
            .build();
    String content = new Gson().toJson(conversionRequestDto);
    when(messageService.getMessage(Mockito.anyString())).thenReturn("");

    conversionService.convert(Mockito.any());
    Mockito.verify(conversionService, Mockito.times(1)).convert(Mockito.any());

    conversionRequestProcessor.process(content);
  }
}
