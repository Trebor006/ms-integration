package com.java.test.msintegration.components.messages;

public interface MessageServiceInterface {

  String getMessage(String key);

  String getMessage(String key, Object[] args);
}
