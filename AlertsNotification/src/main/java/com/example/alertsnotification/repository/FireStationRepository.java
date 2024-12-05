package com.example.alertsnotification.repository;

import com.example.alertsnotification.model.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireStationRepository extends JpaRepository<FireStation, Long> {
    FireStation findByStationNumber(int stationNumber);
}