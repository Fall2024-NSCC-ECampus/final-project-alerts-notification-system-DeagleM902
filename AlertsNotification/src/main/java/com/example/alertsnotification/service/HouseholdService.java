package com.example.alertsnotification.service;

import com.example.alertsnotification.model.Household;
import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Household getHouseholdByAddress(String address) {
        return householdRepository.findByAddress(address).stream().findFirst().orElse(null);
    }

    public Map<String, Object> getChildrenAtAddress(String address) {
        Household household = getHouseholdByAddress(address);
        if (household == null) {
            return Collections.emptyMap();
        }

        List<Person> children = household.getResidents().stream().filter(person -> person.getAge() <= 18).toList();
        List<Person> adults = household.getResidents().stream().filter(person -> person.getAge() > 18).toList();

        if (children.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("children", children);
        result.put("adults", adults);

        return result;
    }
}
