package com.juli0mendes.pocsns.application.core;

import com.juli0mendes.pocsns.adapter.in.PersonDto;
import com.juli0mendes.pocsns.application.ports.in.PersonPortIn;
import com.juli0mendes.pocsns.application.ports.out.PersonBrokerPortOut;
import com.juli0mendes.pocsns.application.ports.out.PersonDatabasePortOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonCore implements PersonPortIn {

    private static final Logger logger = LoggerFactory.getLogger(PersonCore.class);

    private final PersonDatabasePortOut personDatabasePortOut;
    private final PersonBrokerPortOut personBrokerPortOut;

    public PersonCore(final PersonDatabasePortOut personDatabasePortOut, final PersonBrokerPortOut personBrokerPortOut) {
        this.personDatabasePortOut = personDatabasePortOut;
        this.personBrokerPortOut = personBrokerPortOut;
    }

    @Override
    public void createOnExternalSystem(PersonDto personDto) throws Exception {
        this.personBrokerPortOut.publishToQueueTest1(personDto.getName());
    }

    @Override
    public void createOnDatabase(PersonDto personDto) {
        this.personDatabasePortOut.upsert(personDto);
    }

    @Override
    public PersonDto findById(String id) {
        return null;
    }

    @Override
    public void update(String id, PersonDto personDto) {

    }
}
