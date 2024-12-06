package com.example.alertsnotification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO object to be utilized for the Community Email functionality
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityEmailDTO {
    private String firstName;
    private String lastName;
    private String email;
}
