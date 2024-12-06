package com.example.alertsnotification.repository;

import com.example.alertsnotification.model.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the firestation model.
 */
public interface FireStationRepository extends JpaRepository<FireStation, Long> {
    FireStation findByStationNumber(int stationNumber);
}