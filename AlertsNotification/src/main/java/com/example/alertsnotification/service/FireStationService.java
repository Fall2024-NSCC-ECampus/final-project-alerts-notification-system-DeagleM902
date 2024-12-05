package com.example.alertsnotification.service;

import com.example.alertsnotification.model.FireStation;
import com.example.alertsnotification.model.Household;
import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.repository.FireStationRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FireStationService {
    private final FireStationRepository fireStationRepository;

    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    //Get people that are serviced by the given fire station
    public Map<String, Object> getPeopleByStation(int stationNumber) {
        FireStation fireStation = fireStationRepository.findByStationNumber(stationNumber);
        if (fireStation == null) {
            return Collections.emptyMap();
        }
        List<Household> households = fireStation.getHouseholds();
        List<Person> residents = households.stream()
                .flatMap(household -> household.getResidents().stream())
                .toList();

        long adults = residents.stream().filter(person -> person.getAge() > 18).count();
        long children = residents.size() - adults;

        Map<String, Object> result = new HashMap<>();
        result.put("residents", residents);
        result.put("adults", adults);
        result.put("children", children);
        return result;
    }

    public List<String> getPhoneNumbersByStation(int stationNumber) {
        FireStation fireStation = fireStationRepository.findByStationNumber(stationNumber);
        if (fireStation == null) {
            return Collections.emptyList();
        }
        return fireStation.getHouseholds().stream()
                .flatMap(household -> household.getResidents().stream())
                .map(Person::getPhoneNumber)
                .distinct()
                .collect(Collectors.toList());
    }
}
