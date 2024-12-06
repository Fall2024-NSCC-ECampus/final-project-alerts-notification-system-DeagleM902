package com.example.alertsnotification.controller;


import com.example.alertsnotification.service.HouseholdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Endpoint for the Child Alert function
 */
@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {
    private final HouseholdService householdService;

    public ChildAlertController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    /**
     * Get children and other residents at a specific address
     * @param address The address to be searched.
     * @return The number of children nad adults at a given address and their information. Returns empty if no children are present.
     */
    @GetMapping
    public Map<String, Object> getChildrenAtAddress(@RequestParam("address") String address) {
        return householdService.getChildrenAtAddress(address);
    }
}
