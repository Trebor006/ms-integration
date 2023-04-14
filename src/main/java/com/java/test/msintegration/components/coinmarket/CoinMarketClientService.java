package com.java.test.msintegration.components.coinmarket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.test.msintegration.components.coinmarket.deserializers.ResponseDtoDeserializer;
import com.java.test.msintegration.constants.Endpoints;
import com.java.test.msintegration.constants.GeneralConstants;
import com.java.test.msintegration.dto.ConversionRequestDto;
import com.java.test.msintegration.dto.coinmarket.Response;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class CoinMarketClientService implements CoinMarketClientServiceInterface {

  public String COIN_MARKET_URL;

  @Autowired private RestTemplate restTemplate;

  @Value("${coinmarket.url.default}")
  private String DEFAULT_COIN_MARKET_URL;

  @Value("${coinmarket.api.key}")
  private String COIN_MARKET_API_KEY;

  @Value("${coinmarket.header.pro.key}")
  private String COIN_MARKET_HEADER_PRO_KEY;

  @PostConstruct
  public void init() {
    initCoinMarketCapURL();
  }

  private void initCoinMarketCapURL() {
    this.COIN_MARKET_URL = this.DEFAULT_COIN_MARKET_URL;
  }

  @Override
  public Response callConvertCurrency(ConversionRequestDto conversionRequestDto) {
    var url = this.COIN_MARKET_URL + Endpoints.PRICE_CONVERSION;

    var headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add(COIN_MARKET_HEADER_PRO_KEY, COIN_MARKET_API_KEY);

    var requestEntity = new HttpEntity<>(headers);
    var builder = getBuilder(url, conversionRequestDto);

    String response =
        this.restTemplate
            .exchange(
                UriUtils.decode(builder.toUriString(), StandardCharsets.UTF_8),
                HttpMethod.GET,
                requestEntity,
                String.class)
            .getBody();

    Response responseMapped = getResponseMapped(response);

    return responseMapped;
  }

  private static UriComponentsBuilder getBuilder(
      String url, ConversionRequestDto conversionRequestDto) {
    var builder = UriComponentsBuilder.fromHttpUrl(url);

    builder.queryParam(GeneralConstants.AMOUNT, conversionRequestDto.getAmount());
    builder.queryParam(GeneralConstants.SYMBOL, conversionRequestDto.getSymbol());
    builder.queryParam(GeneralConstants.CONVERT, conversionRequestDto.getCurrency());

    return builder;
  }

  private static Response getResponseMapped(String response) {
    Gson gson =
        new GsonBuilder()
            .registerTypeAdapter(Response.class, new ResponseDtoDeserializer())
            .create();

    return gson.fromJson(response, Response.class);
  }
}
