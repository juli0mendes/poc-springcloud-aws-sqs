package com.juli0mendes.pocsnssub.adapter.out.repository;

import com.juli0mendes.pocsnssub.application.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPersonRepository extends MongoRepository<Person, String> {
}
