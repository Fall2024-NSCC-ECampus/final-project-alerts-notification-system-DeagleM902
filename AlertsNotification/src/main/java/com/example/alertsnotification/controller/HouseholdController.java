package com.example.alertsnotification.controller;

import com.example.alertsnotification.model.Household;
import com.example.alertsnotification.service.HouseholdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//The get mappings here are not needed as part of the outlined functions
//They could be repurposed for future needs
@RestController
@RequestMapping("/household")
public class HouseholdController {
    private HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/address")
    public Household getHouseholdByAddress(@RequestParam String address) {
        return householdService.getHouseholdByAddress(address);
    }
}
