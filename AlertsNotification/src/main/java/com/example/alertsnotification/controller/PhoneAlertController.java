package com.example.alertsnotification.controller;

import com.example.alertsnotification.dto.PersonPhoneDTO;
import com.example.alertsnotification.service.FireStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoint for the Phone Alert functionality
 */
@RestController
@RequestMapping("/phoneAlert")
public class PhoneAlertController {
    private final FireStationService fireStationService;

    public PhoneAlertController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    /**
     * Retrieves the name and phone number of residents serviced by the specified firestation
     * @param stationNumber The firestation number.
     * @return The name and phone number of residents serviced by the specified firestation.
     */
    @GetMapping
    public List<PersonPhoneDTO> getPhoneNumberByStation(@RequestParam("firestation") int stationNumber) {
        return fireStationService.getPhoneNumbersByStation(stationNumber);
    }
}
