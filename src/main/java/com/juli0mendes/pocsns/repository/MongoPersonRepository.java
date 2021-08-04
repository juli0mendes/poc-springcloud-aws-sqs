package com.juli0mendes.pocsns.repository;

import com.juli0mendes.pocsns.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPersonRepository extends MongoRepository<Person, String> {
}
