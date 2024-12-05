package com.example.alertsnotification.controller;

import com.example.alertsnotification.dto.PersonInfoDTO;
import com.example.alertsnotification.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {
    private PersonService personService;

    public PersonInfoController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonInfoDTO> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        return personService.getPersonInfo(firstName, lastName);
    }
}
