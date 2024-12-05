package com.example.alertsnotification.repository;

import com.example.alertsnotification.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAddress(String address);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}