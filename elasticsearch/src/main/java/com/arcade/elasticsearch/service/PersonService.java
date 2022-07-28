package com.arcade.elasticsearch.service;

import com.arcade.elasticsearch.document.Person;
import com.arcade.elasticsearch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person createPerson(final Person person) {
        return repository.save(person);
    }

    public Iterable<Person> allPerson() {
        return repository.findAll();
    }

    public Person findPerson(final String id) {
        return repository.findById(id).orElse(null);
    }

    public void deletePerson(final String id) {
        repository.deleteById(id);
    }
}
