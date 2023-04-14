package com.java.test.msintegration.services.processor;

import com.java.test.msintegration.enums.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessorLocatorService implements ProcessorLocatorServiceInterface {

  public final ConversionRequestProcessor conversionRequestProcessor;

  @Override
  public Processor getProcessor(MessageType messageType) {
    log.info("obtaining processor");
    if (messageType.equals(MessageType.CONVERSION_REQUEST)) {
      return conversionRequestProcessor;
    }

    throw new UnsupportedOperationException();
  }
}
