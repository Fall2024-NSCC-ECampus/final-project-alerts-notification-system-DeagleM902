package com.example.alertsnotification.service;

import com.example.alertsnotification.model.Household;
import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service level class for household data.
 */
@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    /**
     * Constructs a HouseholdService with the specified repository
     * @param householdRepository The repository of households.
     */
    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    /**
     * Retrieves a list of all households.
     * @return A list of all households.
     */
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    /**
     * Retrieves a specific household by its address.
     * @param address The address of the household.
     * @return The household corresponding to the address.
     */
    public Household getHouseholdByAddress(String address) {
        return householdRepository.findByAddress(address).stream().findFirst().orElse(null);
    }

    /**
     * Retrieves information about children and adults at a given address.
     *
     * This method identifies all residents at the specified address, categorizes them as either
     * children (age <= 18) or adults (age > 18), and returns the results as a map.
     *
     * @param address The address of the household.
     * @return If there are children, the number of children and adults, as well as their information.
     * If there are no children, an empty map.
     */
    public Map<String, Object> getChildrenAtAddress(String address) {
        Household household = getHouseholdByAddress(address);
        if (household == null) {
            return Collections.emptyMap();
        }

        //Children are defined as 18 or under
        List<Person> children = household.getResidents().stream().filter(person -> person.getAge() <= 18).toList();
        List<Person> adults = household.getResidents().stream().filter(person -> person.getAge() > 18).toList();

        //Returns an empty map if there are no children
        if (children.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("children", children);
        result.put("adults", adults);

        return result;
    }
}
