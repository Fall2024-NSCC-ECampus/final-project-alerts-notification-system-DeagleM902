package com.example.alertsnotification.repository;

import com.example.alertsnotification.dto.CommunityEmailDTO;
import com.example.alertsnotification.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for the Person model
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAddress(String address);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT p FROM Person p JOIN p.household h JOIN h.fireStation fs WHERE fs.stationNumber = :stationNumber")
    List<Person> findByFireStationNumber(int stationNumber);

    @Query("SELECT new com.example.alertsnotification.dto.CommunityEmailDTO(p.firstName, p.lastName, p.email) FROM Person p WHERE p.city = :city")
    List<CommunityEmailDTO> findEmailByCity(@Param("city") String city);
}