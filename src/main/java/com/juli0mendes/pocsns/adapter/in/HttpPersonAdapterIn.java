package com.juli0mendes.pocsns.adapter.in;

import com.juli0mendes.pocsns.application.ports.in.PersonPortIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poc/v1/persons")
public class HttpPersonAdapterIn {

    private static final Logger logger = LoggerFactory.getLogger(HttpPersonAdapterIn.class);

    private final PersonPortIn personPortIn;

    public HttpPersonAdapterIn(final PersonPortIn personPortIn) {
        this.personPortIn = personPortIn;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PersonDto personDto) throws Exception {

        this.personPortIn.createOnExternalSystem(personDto);

        return ResponseEntity.accepted().build();
    }
}
