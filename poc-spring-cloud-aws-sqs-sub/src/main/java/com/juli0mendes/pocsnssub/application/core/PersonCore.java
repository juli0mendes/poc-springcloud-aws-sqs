package com.juli0mendes.pocsnssub.application.core;

import com.juli0mendes.pocsnssub.adapter.in.PersonDto;
import com.juli0mendes.pocsnssub.application.ports.in.PersonPortIn;
import com.juli0mendes.pocsnssub.application.ports.out.PersonDatabasePortOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PersonCore implements PersonPortIn {

    private static final Logger logger = LoggerFactory.getLogger(PersonCore.class);

    private final PersonDatabasePortOut personDatabasePortOut;

    public PersonCore(final PersonDatabasePortOut personDatabasePortOut) {
        this.personDatabasePortOut = personDatabasePortOut;
    }

    @Override
    public void createOnDatabase(PersonDto personDto) {
        this.personDatabasePortOut.upsert(personDto);
    }

    @Override
    public PersonDto findById(String id) {
        // TODO -- to implement
        return null;
    }

    @Override
    public void update(String id, PersonDto personDto) {
        // TODO -- to implement
    }
}
