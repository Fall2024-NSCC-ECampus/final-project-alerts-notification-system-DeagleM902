package com.example.alertsnotification.controller;

import com.example.alertsnotification.service.FireStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Endpoint for fire station functions
 */
@RestController
@RequestMapping("/firestation")
public class FireStationController {
    private final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    /**
     * Retrieves the information of all residents serviced by the given firestation.
     * @param stationNumber The firstation number.
     * @return The information of all residents serviced by the given firestation.
     */
    @GetMapping
    public Map<String, Object> getPeopleByStation(@RequestParam("stationNumber") int stationNumber) {
        return fireStationService.getPeopleByStation(stationNumber);
    }
}
