package com.example.alertsnotification.repository;

import com.example.alertsnotification.model.Household;
import com.example.alertsnotification.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    List<Household> findByAddress(String address);
}