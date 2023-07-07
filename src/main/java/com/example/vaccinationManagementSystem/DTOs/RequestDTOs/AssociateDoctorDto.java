package com.example.vaccinationManagementSystem.DTOs.RequestDTOs;

import lombok.Data;

@Data
public class AssociateDoctorDto {
    private Integer docId;
    private Integer centerId;
}
