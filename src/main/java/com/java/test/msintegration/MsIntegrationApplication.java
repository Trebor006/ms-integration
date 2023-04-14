package com.java.test.msintegration;

import com.java.test.msintegration.components.artemis.ArtemisProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class MsIntegrationApplication {

//  @Autowired private ArtemisProducer producer;

  public static void main(String[] args) {
    SpringApplication.run(MsIntegrationApplication.class, args);
  }

  @Bean
  public RestTemplate getresttemplate() {
    return new RestTemplate();
  }
  //
  //    @Autowired
  //    private ArtemisListenerProcessor artemisListenerProcessor;
  //
  //    @PostConstruct
  //    public void test() {
  //
  //        var messageType = MessageType.CONVERSION_REQUEST;
  //        var conversionRequestDto = ConversionRequestDto.builder()
  //                .amount(25000D)
  //                .symbol("USD")
  //                .currency("BTC")
  //                .build();
  //
  //        var message = QueueMessage.builder()
  //                .type(messageType)
  //                .content(new Gson().toJson(conversionRequestDto))
  //                .build();
  //
  //        producer.sendMessage(message);
  ////        artemisListenerProcessor.process(new Gson().toJson(message));
  //    }
}
