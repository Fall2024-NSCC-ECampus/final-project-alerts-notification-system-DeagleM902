package com.example.alertsnotification.service;

import com.example.alertsnotification.dto.CommunityEmailDTO;
import com.example.alertsnotification.dto.PersonInfoDTO;
import com.example.alertsnotification.exception.EntityNotFoundException;
import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
        List<Person> residents = personRepository.findByAddress(address);
        if (residents.isEmpty()) {
            throw new EntityNotFoundException("No residents found at address " + address);
        }
        return residents;
    }

    public List<Person> getPersonsByName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<CommunityEmailDTO> getEmailByCity(String city) {
        return personRepository.findEmailByCity(city);
    }

    public List<PersonInfoDTO> getPersonInfo(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName).stream()
                .map(person -> new PersonInfoDTO(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getAddress(),
                        person.getAge(),
                        person.getEmail(),
                        person.getMedications(),
                        person.getAllergies()
                ))
                .collect(Collectors.toList());
    }
}
