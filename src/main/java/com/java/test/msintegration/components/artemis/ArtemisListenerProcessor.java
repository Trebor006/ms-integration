package com.java.test.msintegration.components.artemis;

import com.google.gson.Gson;
import com.java.test.msintegration.components.messages.MessageServiceInterface;
import com.java.test.msintegration.dto.QueueMessage;
import com.java.test.msintegration.services.processor.ProcessorLocatorServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArtemisListenerProcessor implements ListenerProcessorInterface {

  private final ProcessorLocatorServiceInterface processorService;
  private final MessageServiceInterface messageService;

  @Override
  public void process(String content) {
    log.info(messageService.getMessage("process.starting"));
    var gson = new Gson();
    var queueMessage = gson.fromJson(content, QueueMessage.class);
    var processor = processorService.getProcessor(queueMessage.getType());
    processor.process(queueMessage.getContent());
  }
}
