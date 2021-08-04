package com.juli0mendes.pocpocsqspub.application.core;

import com.juli0mendes.pocpocsqspub.adapter.in.PersonDto;
import com.juli0mendes.pocpocsqspub.application.ports.in.PersonPortIn;
import com.juli0mendes.pocpocsqspub.application.ports.out.PersonBrokerPortOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonCore implements PersonPortIn {

    private static final Logger logger = LoggerFactory.getLogger(PersonCore.class);

    private final PersonBrokerPortOut personBrokerPortOut;

    public PersonCore(final PersonBrokerPortOut personBrokerPortOut) {
        this.personBrokerPortOut = personBrokerPortOut;
    }

    @Override
    public void createOnExternalSystem(PersonDto personDto) throws Exception {
        this.personBrokerPortOut.publishToQueueTest1(personDto);
    }
}
