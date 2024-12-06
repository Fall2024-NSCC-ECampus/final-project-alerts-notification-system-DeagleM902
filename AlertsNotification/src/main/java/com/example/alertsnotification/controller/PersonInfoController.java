package com.example.alertsnotification.controller;

import com.example.alertsnotification.dto.PersonInfoDTO;
import com.example.alertsnotification.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoint for the Personal Information retrieval functionality
 */
@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {
    private final PersonService personService;

    public PersonInfoController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Retrieves all information for residents with a specified first and last name
     * @param firstName The first name to be searched.
     * @param lastName The last name to be searched.
     * @return The information of residents with matching first and last name.
     */
    @GetMapping
    public List<PersonInfoDTO> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        return personService.getPersonInfo(firstName, lastName);
    }
}
