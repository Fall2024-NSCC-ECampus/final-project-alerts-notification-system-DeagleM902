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

/**
 * Service level class for Person data.
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    /**
     * Constructs a PersonRepository with the specified repository
     * @param personRepository The repository of residents.
     */
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Retrieves a list of all residents/Persons.
     * @return A list of all Person objects.
     */
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    /**
     * Retrieves the residents at a specified address.
     * @param address The address to be searched.
     * @return The information of the residents at the given address.
     */
    public List<Person> getPersonsByAddress(String address) {
        List<Person> residents = personRepository.findByAddress(address);
        if (residents.isEmpty()) {
            throw new EntityNotFoundException("No residents found at address " + address);
        }
        return residents;
    }

    /**
     * Retrieves the information of all residents with the given name.
     * @param firstName The first name to search.
     * @param lastName The last name to search.
     * @return The information of all residents with the given first / last name combination.
     */
    public List<Person> getPersonsByName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    /**
     * Retrieves the name and email of all residents of a given city.
     * @param city The city to search.
     * @return The name and email of all residents of the given city.
     */
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
