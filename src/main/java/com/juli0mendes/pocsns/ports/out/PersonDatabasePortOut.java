package com.juli0mendes.pocsns.ports.out;

import com.juli0mendes.pocsns.adapter.in.PersonDto;
import com.juli0mendes.pocsns.domain.Person;

public interface PersonDatabasePortOut {
    Person upsert(PersonDto personDto);
}
