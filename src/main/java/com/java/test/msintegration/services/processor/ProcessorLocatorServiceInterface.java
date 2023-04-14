package com.java.test.msintegration.services.processor;

import com.java.test.msintegration.enums.MessageType;

public interface ProcessorLocatorServiceInterface {
  Processor getProcessor(MessageType messageType);
}
