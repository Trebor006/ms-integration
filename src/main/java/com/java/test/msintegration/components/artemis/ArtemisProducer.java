package com.java.test.msintegration.components.artemis;

import com.google.gson.Gson;
import com.java.test.msintegration.components.messages.MessageServiceInterface;
import com.java.test.msintegration.constants.GeneralConstants;
import com.java.test.msintegration.dto.QueueMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArtemisProducer implements ProducerInterface {

  private final JmsTemplate jmsTemplate;
  private final MessageServiceInterface messageService;

  @Override
  public void sendMessage(QueueMessage message) {

    String queueBodyContent = new Gson().toJson(message);
    log.info(
        messageService.getMessage(
            "artemis.process.confirm.sending.message",
            new String[] {String.valueOf(queueBodyContent)}));

    this.jmsTemplate.send(
        GeneralConstants.QUEUE_NAME, session -> session.createTextMessage(queueBodyContent));

    log.info(messageService.getMessage("process.confirm.sent.message"));
  }
}
