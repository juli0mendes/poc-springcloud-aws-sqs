package com.juli0mendes.pocsns.ports.in;

import com.juli0mendes.pocsns.adapter.in.PersonDto;

public interface PersonPortIn {

    void createOnExternalSystem(PersonDto personDto) throws Exception;

    void createOnDatabase(PersonDto personDto);

    PersonDto findById(String id);

    void update(String id, PersonDto personDto);
}
