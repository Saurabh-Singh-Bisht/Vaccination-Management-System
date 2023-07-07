package com.example.vaccinationManagementSystem.Transformers;

import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.AppointmentResponseDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.DoctorResponseDto;
import com.example.vaccinationManagementSystem.Models.Appointment;
import com.example.vaccinationManagementSystem.Models.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoctorTransformer {
    public static List<DoctorResponseDto> doctorListToDoctorResponseDto(List<Doctor> doctorList, int centerId){
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();
        for (Doctor doctor: doctorList){
            if (doctor.getVaccinationCenter() != null){
                int center = doctor.getVaccinationCenter().getId();
                if (center == centerId){
                    DoctorResponseDto doctorResponseDto = DoctorResponseDto.builder()
                            .name(doctor.getName())
                            .age(doctor.getAge())
                            .gender(doctor.getGender())
                            .email(doctor.getEmailId())
                            .build();
                    doctorResponseDtos.add(doctorResponseDto);
                }
            }
        }
        return doctorResponseDtos;
    }
    public static DoctorResponseDto doctorListToDoctorResponse(Doctor doctor){
        DoctorResponseDto doctorResponseDto = DoctorResponseDto.builder()
                .name(doctor.getName())
                .age(doctor.getAge())
                .gender(doctor.getGender())
                .email(doctor.getEmailId())
                .build();
        ;
        return doctorResponseDto;
    }
    public static List<AppointmentResponseDto> appointmentToAppointmentResponseDto(List<Appointment> appointmentList){
        List<AppointmentResponseDto> appointmentResponseDtos = new ArrayList<>();
        for (Appointment appointment: appointmentList){
            AppointmentResponseDto appointmentResponseDto = AppointmentResponseDto.builder()
                    .date(appointment.getAppointmentDate())
                    .time(appointment.getAppointmentTime())
//                    .user(appointment.getUser().getName())
                    .build();
            appointmentResponseDtos.add(appointmentResponseDto);
        }
        return appointmentResponseDtos;
    }
}
