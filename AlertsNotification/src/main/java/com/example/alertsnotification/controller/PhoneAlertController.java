package com.example.alertsnotification.controller;

import com.example.alertsnotification.dto.PersonPhoneDTO;
import com.example.alertsnotification.service.FireStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phoneAlert")
public class PhoneAlertController {
    private FireStationService fireStationService;

    public PhoneAlertController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping
    public List<PersonPhoneDTO> getPhoneNumberByStation(@RequestParam("firestation") int stationNumber) {
        return fireStationService.getPhoneNumbersByStation(stationNumber);
    }
}
