package com.example.alertsnotification.controller;

import com.example.alertsnotification.dto.CommunityEmailDTO;
import com.example.alertsnotification.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/communityEmail")
public class CommunityEmailController {
    private PersonService personService;

    public CommunityEmailController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<CommunityEmailDTO> getCommunityEmail(@RequestParam String city) {
        return personService.getEmailByCity(city);
    }
}
