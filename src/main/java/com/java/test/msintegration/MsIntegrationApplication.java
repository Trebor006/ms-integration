package com.java.test.msintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class MsIntegrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsIntegrationApplication.class, args);
  }

  @Bean
  public RestTemplate getresttemplate() {
    return new RestTemplate();
  }
}
