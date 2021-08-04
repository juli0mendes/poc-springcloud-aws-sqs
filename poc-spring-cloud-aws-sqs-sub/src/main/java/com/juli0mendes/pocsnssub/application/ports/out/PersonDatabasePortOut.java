package com.juli0mendes.pocsnssub.application.ports.out;

import com.juli0mendes.pocsnssub.adapter.in.PersonDto;
import com.juli0mendes.pocsnssub.application.domain.Person;

public interface PersonDatabasePortOut {
    Person upsert(PersonDto personDto);
}
