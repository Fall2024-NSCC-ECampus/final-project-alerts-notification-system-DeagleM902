package com.example.alertsnotification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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