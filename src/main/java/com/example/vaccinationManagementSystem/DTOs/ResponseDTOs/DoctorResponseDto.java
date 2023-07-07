package com.example.vaccinationManagementSystem.DTOs.ResponseDTOs;

import com.example.vaccinationManagementSystem.Enums.Gender;
import com.example.vaccinationManagementSystem.Models.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDto {
    private String name;
    private int age;
    private Gender gender;
    private String email;
}
