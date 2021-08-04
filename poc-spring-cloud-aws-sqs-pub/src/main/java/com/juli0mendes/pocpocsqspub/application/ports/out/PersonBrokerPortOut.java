package com.juli0mendes.pocpocsqspub.application.ports.out;

import com.juli0mendes.pocpocsqspub.adapter.in.PersonDto;

public interface PersonBrokerPortOut {

    void publishToQueueTest1(PersonDto personDto) throws Exception;
}
