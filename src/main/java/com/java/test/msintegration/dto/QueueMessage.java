package com.java.test.msintegration.dto;

import com.java.test.msintegration.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueMessage {

  private MessageType type;
  private String content;
}
