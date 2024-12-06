package com.example.alertsnotification.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class representing a firestation.
 * Contains fields for station number and address.
 * Households can be assigned to a firestation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fire_station")
public class FireStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_number")
    private int stationNumber;

    @Column(name = "station_address")
    private String stationAddress;

    @OneToMany(mappedBy = "fireStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Household> households;
}
