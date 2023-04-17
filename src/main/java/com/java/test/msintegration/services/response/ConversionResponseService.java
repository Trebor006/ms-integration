package com.java.test.msintegration.services.response;

import com.google.gson.Gson;
import com.java.test.msintegration.components.artemis.ProducerInterface;
import com.java.test.msintegration.components.messages.MessageServiceInterface;
import com.java.test.msintegration.dto.QueueMessage;
import com.java.test.msintegration.entities.ConversionEntity;
import com.java.test.msintegration.enums.MessageType;
import com.java.test.msintegration.services.mapper.ConversionMapperServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversionResponseService implements ConversionResponseServiceInterface {

  private final MessageServiceInterface messageService;
  private final ConversionMapperServiceInterface conversionMapperService;
  private final ProducerInterface producer;

  @Override
  @Async
  public void generateResponse(ConversionEntity conversion) {
    log.info(messageService.getMessage("process.getting.response"));
    var conversionResponseDto = conversionMapperService.mapToResult(conversion);
    var message =
        QueueMessage.builder()
            .type(MessageType.CONVERSION_RESPONSE)
            .content(new Gson().toJson(conversionResponseDto))
            .build();

    producer.sendMessage(message);
  }
}
