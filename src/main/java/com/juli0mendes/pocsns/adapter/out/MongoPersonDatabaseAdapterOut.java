package com.juli0mendes.pocsns.adapter.out;

import com.juli0mendes.pocsns.adapter.in.PersonDto;
import com.juli0mendes.pocsns.domain.Person;
import com.juli0mendes.pocsns.ports.out.PersonDatabasePortOut;
import com.juli0mendes.pocsns.repository.MongoPersonRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class MongoPersonDatabaseAdapterOut implements PersonDatabasePortOut {

    private final MongoPersonRepository mongoPersonRepository;
    private final MongoTemplate mongoTemplate;

    public MongoPersonDatabaseAdapterOut(final MongoPersonRepository mongoPersonRepository,
                                         final MongoTemplate mongoTemplate) {
        this.mongoPersonRepository = mongoPersonRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Person upsert(PersonDto personDto) {

        Optional<Person> personExisting = null;

        if (personDto.getId() != null) {
            personExisting = this.mongoPersonRepository.findById(personDto.getId());

            if (personExisting.isEmpty())
                return this.mongoPersonRepository.save(Person.update(personExisting.get().getId(), personDto.getName(), personExisting.get().getCreatedAt()));
        }

        return this.mongoPersonRepository.save(Person.create(personDto.getName()));

    }
}
