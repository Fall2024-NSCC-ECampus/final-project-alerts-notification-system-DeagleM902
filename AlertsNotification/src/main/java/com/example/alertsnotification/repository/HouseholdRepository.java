package com.example.alertsnotification.repository;

import com.example.alertsnotification.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for the Household model.
 */
public interface HouseholdRepository extends JpaRepository<Household, Long> {
    List<Household> findByAddress(String address);
}