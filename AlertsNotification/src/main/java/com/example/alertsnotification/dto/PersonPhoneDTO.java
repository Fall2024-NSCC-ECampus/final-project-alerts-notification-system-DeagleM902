package com.example.alertsnotification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO object to be utilized for the Residents Phone number functionality
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonPhoneDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
}
