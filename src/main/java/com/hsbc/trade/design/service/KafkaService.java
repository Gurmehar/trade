package com.hsbc.trade.design.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);



    public void send(JsonNode jsonNode,String topic) {

            logger.info("Pushing payment request: {} to Kafka...", jsonNode);

        }
    }


