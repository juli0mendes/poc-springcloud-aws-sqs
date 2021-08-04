package com.juli0mendes.pocsns.adapter.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juli0mendes.pocsns.ports.in.PersonPortIn;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static com.juli0mendes.pocsns.config.BrokerInput.QUEUE_TEST_1;
import static io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy.ON_SUCCESS;

@Service
public class TcpAwsSqsPersonAdapterIn {

    private static final Logger logger = LoggerFactory.getLogger(TcpAwsSqsPersonAdapterIn.class);

    private final ObjectMapper objectMapper;
    private final PersonPortIn personPortIn;

    public TcpAwsSqsPersonAdapterIn(ObjectMapper objectMapper,
                                    final PersonPortIn personPortIn) {
        this.objectMapper = objectMapper;
        this.personPortIn = personPortIn;
    }

    @SqsListener(value = QUEUE_TEST_1, deletionPolicy = ON_SUCCESS)
    public void receiveMessage(String message, @Header("SenderId") String senderId) {

        try {
            PersonDto personDto = this.objectMapper.readValue(message, PersonDto.class);

            this.personPortIn.createOnDatabase(personDto);

            logger.info("message received {} {}", senderId, message);
        } catch (JsonProcessingException e) {
            logger.error("error serializing message: {}", e.getMessage());
        }
    }
}
