package com.java.test.msintegration.components.coinmarket.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.java.test.msintegration.constants.GeneralConstants;
import com.java.test.msintegration.dto.coinmarket.Response;
import com.java.test.msintegration.dto.coinmarket.ResponseData;
import com.java.test.msintegration.dto.coinmarket.ResponseStatus;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResponseDtoDeserializer implements JsonDeserializer<Response> {

  @Override
  public Response deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    var jsonObject = json.getAsJsonObject();
    var response =
        Response.builder()
            .status(
                context.deserialize(jsonObject.get(GeneralConstants.STATUS), ResponseStatus.class))
            .data(new ArrayList<>())
            .build();

    var jsonArray = jsonObject.getAsJsonArray(GeneralConstants.DATA);
    for (JsonElement element : jsonArray) {
      response.getData().add(context.deserialize(element, ResponseData.class));
    }

//    for (JsonElement element : jsonArray) {
//      JsonObject dataObject = element.getAsJsonObject();
//      var responseData =
//          ResponseData.builder()
//              .id(dataObject.get(GeneralConstants.ID).getAsInt())
//              .symbol(dataObject.get(GeneralConstants.SYMBOL).getAsString())
//              .name(dataObject.get(GeneralConstants.NAME).getAsString())
//              .amount(dataObject.get(GeneralConstants.AMOUNT).getAsDouble())
//              .lastUpdated(dataObject.get(GeneralConstants.LAST_UPDATED).getAsString())
//              .quote(new HashMap<>())
//              .build();
//
//      var quoteObject = dataObject.getAsJsonObject(GeneralConstants.QUOTE);
//      for (String key : quoteObject.keySet()) {
//        Quote quote = context.deserialize(quoteObject.get(key), Quote.class);
//        responseData.getQuote().put(key, quote);
//      }
//      response.getData().add(responseData);
//    }

    return response;
  }
}
