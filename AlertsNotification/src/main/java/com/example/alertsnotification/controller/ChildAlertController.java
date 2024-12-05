package com.example.alertsnotification.controller;


import com.example.alertsnotification.service.HouseholdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {
    private HouseholdService householdService;

    public ChildAlertController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public Map<String, Object> getChildrenAtAddress(@RequestParam("address") String address) {
        return householdService.getChildrenAtAddress(address);
    }
}
