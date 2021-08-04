package com.juli0mendes.pocpocsqspub.application.ports.in;

import com.juli0mendes.pocpocsqspub.adapter.in.PersonDto;

public interface PersonPortIn {

    void createOnExternalSystem(PersonDto personDto) throws Exception;
}
