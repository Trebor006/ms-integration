package com.java.test.msintegration.components.artemis;

import com.java.test.msintegration.dto.QueueMessage;

public interface ProducerInterface {
  void sendMessage(QueueMessage message);
}
