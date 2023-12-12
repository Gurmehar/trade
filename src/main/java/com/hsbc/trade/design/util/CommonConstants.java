package com.hsbc.trade.design.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.trade.design.model.Trade;
import java.util.Date;

public class CommonConstants {

    public static final long VALIDITY = 600;

    private static final ObjectMapper objectMapper= new ObjectMapper();

    public  static JsonNode getJson(Trade trade){
        return objectMapper.convertValue(trade,JsonNode.class);
    }


    public static void isLockTimeOver(Date lockTime) {
        //compare with current datetime , current time should be than lock time
        //as lock time when  saved 10 mins are added in it .
    }
}
