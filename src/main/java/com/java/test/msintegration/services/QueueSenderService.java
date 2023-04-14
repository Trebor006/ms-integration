package com.java.test.msintegration.services;

import com.java.test.msintegration.components.artemis.ProducerInterface;
import com.java.test.msintegration.dto.QueueMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueueSenderService {

  private final ProducerInterface producer;

  public void sendResponse(QueueMessage message) {
    producer.sendMessage(message);
  }
}
