package com.java.test.msintegration.components.artemis;

import com.google.gson.Gson;
import com.java.test.msintegration.constants.GeneralConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArtemisListener implements ListenerInterface {

  private final ListenerProcessorInterface listenerProcessor;

  @Override
  @JmsListener(destination = GeneralConstants.QUEUE_NAME)
  public void processMessage(String content) {
    log.info("message received :: " + new Gson().toJson(content));

    listenerProcessor.process(content);
  }
}
