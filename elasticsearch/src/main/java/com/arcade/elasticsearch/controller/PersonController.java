package com.arcade.elasticsearch.controller;

import com.arcade.elasticsearch.document.Person;
import com.arcade.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public Iterable<Person> allPerson() {
        return personService.allPerson();
    }

    @GetMapping("/{id}")
    public Person findPerson(@PathVariable String id) {
        return personService.findPerson(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }
}
