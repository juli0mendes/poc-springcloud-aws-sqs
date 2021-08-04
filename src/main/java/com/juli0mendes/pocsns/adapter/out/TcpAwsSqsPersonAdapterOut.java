package com.juli0mendes.pocsns.adapter.out;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juli0mendes.pocsns.adapter.in.PersonDto;
import com.juli0mendes.pocsns.application.ports.out.PersonBrokerPortOut;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TcpAwsSqsPersonAdapterOut implements PersonBrokerPortOut {

    private static final Logger logger = LoggerFactory.getLogger(TcpAwsSqsPersonAdapterOut.class);

    private static final String QUEUE_NAME = "https://sqs.us-east-1.amazonaws.com/351302643189/sqs-test-1";

    private final AmazonSQSAsync amazonSqs;
    private final ObjectMapper objectMapper;

    public TcpAwsSqsPersonAdapterOut(final AmazonSQSAsync amazonSqs, final ObjectMapper objectMapper) {
        this.amazonSqs = amazonSqs;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishToQueueTest1(String name) throws Exception {
        MessageChannel messageChannel = new QueueMessageChannel(this.amazonSqs, QUEUE_NAME);

        PersonDto personDto = new PersonDto();
        personDto.setName(name);

        String messagePayload = this.objectMapper.writeValueAsString(personDto);

        Message<String> message = MessageBuilder.withPayload(messagePayload)
                .setHeader("sender", "app1")
                .setHeaderIfAbsent("country", "BR")
                .build();

        long waitTimeoutMillis = 5000;

        boolean sentStatus = messageChannel.send(message, waitTimeoutMillis);

        if (!sentStatus)
            throw new Exception();

        logger.info("message sent");

    }
}
