package com.example.vaccinationManagementSystem.DTOs.RequestDTOs;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentRequestDto {
    private int doctorId;
    private int userId;
    private Date appointmentDate;
    private LocalTime appointmentTime;
}
