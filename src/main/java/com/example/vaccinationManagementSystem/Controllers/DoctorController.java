package com.example.vaccinationManagementSystem.Controllers;

import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.AppointmentRequestDto;
import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.AssociateDoctorDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.AppointmentResponseDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.DoctorResponseDto;
import com.example.vaccinationManagementSystem.Models.Doctor;
import com.example.vaccinationManagementSystem.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        try {
            String response = doctorService.add(doctor);
            return response;
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }
    @PostMapping("/associateCenterToDoctor")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDoctorDto associateDoctorDto){
        try{
            String result = doctorService.associateDoctor(associateDoctorDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getRatioOfMaleAndFemaleDoctors")
    public String getRatioOfMaleAndFemaleDoctors(){
        return doctorService.getRatioOfMaleAndFemaleDoctors();
    }
    @GetMapping("/getListOfDoctorsAtCenter")
    public List<DoctorResponseDto> getListOfDoctorsAtCenter(@RequestParam int centerId){
        return doctorService.getListOfDoctorsAtCenter(centerId);
    }
    @GetMapping("/getListOfMaleDoctorAtCenter")
    public List<DoctorResponseDto> getListOfMaleDoctorAtCenter(@RequestParam int centerId){
        return doctorService.getListOfMaleDoctorAtCenter(centerId);
    }
    @GetMapping("/getListOfFemaleDoctorAtCenter")
    public List<DoctorResponseDto> getListOfFemaleDoctorAtCenter(@RequestParam int centerId){
        return doctorService.getListOfFemaleDoctorAtCenter(centerId);
    }
    @GetMapping("/getDoctorAllAppointments")
    public List<AppointmentResponseDto> getDoctorAllAppointments(@RequestParam int doctorId){
        return doctorService.getDoctorAllAppointments(doctorId);
    }
}
