package com.juli0mendes.pocsnssub.application.ports.in;

import com.juli0mendes.pocsnssub.adapter.in.PersonDto;

public interface PersonPortIn {

    void createOnDatabase(PersonDto personDto);

    PersonDto findById(String id);

    void update(String id, PersonDto personDto);
}
