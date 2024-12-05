package com.example.alertsnotification.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "household")
public class Household {
    @Id
    @GeneratedValue
    private Long id;

    private String address; //Unique identifier, not ideal as identical stationAddress can be present in another city

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Person> residents;

    @ManyToOne
    @JoinColumn(name = "fire_station_id", nullable = false)
    @JsonManagedReference
    private FireStation fireStation;
}
