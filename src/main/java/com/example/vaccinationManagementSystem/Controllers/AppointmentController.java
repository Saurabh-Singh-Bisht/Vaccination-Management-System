package com.example.vaccinationManagementSystem.Controllers;

import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.AppointmentRequestDto;
import com.example.vaccinationManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccinationManagementSystem.Exceptions.UserNotFoundException;
import com.example.vaccinationManagementSystem.Models.User;
import com.example.vaccinationManagementSystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointmentController")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto){
        try {
            String result = appointmentService.bookAppointment(appointmentRequestDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (UserNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (DoctorNotFound ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
