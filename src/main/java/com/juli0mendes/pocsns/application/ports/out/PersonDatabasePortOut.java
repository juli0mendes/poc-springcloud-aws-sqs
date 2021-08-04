package com.juli0mendes.pocsns.application.ports.out;

import com.juli0mendes.pocsns.adapter.in.PersonDto;
import com.juli0mendes.pocsns.application.domain.Person;

public interface PersonDatabasePortOut {
    Person upsert(PersonDto personDto);
}
