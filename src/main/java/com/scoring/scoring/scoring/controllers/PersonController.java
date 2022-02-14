package com.scoring.scoring.scoring.controllers;

import com.scoring.scoring.exception.NoSuchEntityException;
import com.scoring.scoring.scoring.domain.Person;
import com.scoring.scoring.scoring.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping("/persons")
    public List<Person> read() {
        return personService.getAll();

    }

    @GetMapping("/persons/{id}")
    public Person get(@PathVariable("id") UUID uuid) {
        Person person = personService.getById(uuid);
        if (person == null) {
            throw new NoSuchEntityException("There is no person with id " + uuid + " in DataBase");
        }

        return personService.getById(uuid);

    }

    @PostMapping("/persons")
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }


    @PutMapping("/persons")
    public Person update(@RequestBody Person person) {
        return personService.update(person);

    }

    @DeleteMapping("/persons/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        Person person = personService.getById(uuid);
        if (person == null) {
            throw new NoSuchEntityException("There is no person with id " + uuid + " in DB");
        }
        personService.delete(personService.getById(uuid));
        return "Person with id  = " + uuid + " was deleted";
    }
}
