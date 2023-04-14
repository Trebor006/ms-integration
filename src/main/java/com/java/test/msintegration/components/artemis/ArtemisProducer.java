package com.java.test.msintegration.components.artemis;

import com.google.gson.Gson;
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

  @Override
  public void sendMessage(QueueMessage message) {

    String queueBodyContent = new Gson().toJson(message);
    log.info("sending message :: " + queueBodyContent);

    this.jmsTemplate.send(
        GeneralConstants.QUEUE_NAME, session -> session.createTextMessage(queueBodyContent));

    log.info("message already sent");
  }
}
