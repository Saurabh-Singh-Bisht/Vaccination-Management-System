package com.example.vaccinationManagementSystem.DTOs.ResponseDTOs;

import com.example.vaccinationManagementSystem.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDto {
    private Date date;
    private LocalTime time;
//    private String user;
}
