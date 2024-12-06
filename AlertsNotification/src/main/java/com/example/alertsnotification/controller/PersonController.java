package com.example.alertsnotification.controller;

import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//The get mappings here are not needed as part of the outlined functions
//They could be repurposed for future needs
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/address")
    public List<Person> getPersonByAddress(@RequestParam String address) {
        return personService.getPersonsByAddress(address);
    }

    @GetMapping("/search")
    public List<Person> getPersonByName(@RequestParam String firstName, String lastName) {
        return personService.getPersonsByName(firstName, lastName);
    }
}
