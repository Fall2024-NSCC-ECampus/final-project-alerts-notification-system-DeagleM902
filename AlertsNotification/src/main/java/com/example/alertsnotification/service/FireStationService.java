package com.example.alertsnotification.service;

import com.example.alertsnotification.dto.PersonPhoneDTO;
import com.example.alertsnotification.model.FireStation;
import com.example.alertsnotification.model.Household;
import com.example.alertsnotification.model.Person;
import com.example.alertsnotification.repository.FireStationRepository;
import com.example.alertsnotification.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service level class for fire station data.
 */
@Service
public class FireStationService {
    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;

    /**
     * Constructs a FireStationService with the specified fireStationRepository and personRepository.
     * @param fireStationRepository The firestation repository.
     * @param personRepository The Person repository.
     */
    public FireStationService(FireStationRepository fireStationRepository, PersonRepository personRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
    }

    /**
     * Retrieves all information from the residents serviced by the given firestation
     * @param stationNumber The fire station to retrieve the information from.
     * @return The residents serviced by the given firestation.
     */
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

    /**
     * Retrieves the name and phone number of the residents serviced by the given firestation.
     * @param stationNumber The specified firestation.
     * @return The name and phone number of residents serviced by the given firestation.
     */
    public List<PersonPhoneDTO> getPhoneNumbersByStation(int stationNumber) {
        return personRepository.findByFireStationNumber(stationNumber).stream()
                .map(person -> new PersonPhoneDTO(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getAddress(),
                        person.getPhoneNumber()
                ))
                .collect(Collectors.toList());
    }
}
