package com.example.vaccinationManagementSystem.DTOs.ResponseDTOs;

import com.example.vaccinationManagementSystem.Enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String name;
    private int age;
    private String email;
    private Gender gender;
    private String mobileNo;
}
