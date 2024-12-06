package com.example.alertsnotification.controller;

import com.example.alertsnotification.dto.CommunityEmailDTO;
import com.example.alertsnotification.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoint for the Email address functionality
 */
@RestController
@RequestMapping("/communityEmail")
public class CommunityEmailController {
    private final PersonService personService;

    public CommunityEmailController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Gathers the name and email of everyone in a specified city
     * @param city The city.
     * @return The name and email of all residents of the given city.
     */
    @GetMapping
    public List<CommunityEmailDTO> getCommunityEmail(@RequestParam String city) {
        return personService.getEmailByCity(city);
    }
}
