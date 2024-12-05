package com.example.alertsnotification.service;

import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> getPersonsByAddress(String address) {
        return personRepository.findByAddress(address);
    }

    public List<Person> getPersonsByName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
