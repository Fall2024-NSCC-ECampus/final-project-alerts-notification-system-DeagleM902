package com.example.alertsnotification.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "residents")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;
    private String city;

    @Column(name = "phone_number") // Explicitly map to database column
    private String phoneNumber;

    private String email;
    private int age;

    @ElementCollection
    @CollectionTable(name = "person_medications", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "medication")
    private List<String> medications;

    @ElementCollection
    @CollectionTable(name = "person_allergies", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name="allergy")
    private List<String> allergies;

    @ManyToOne
    @JoinColumn(name = "household_id", nullable = false)
    @JsonBackReference
    private Household household;
}