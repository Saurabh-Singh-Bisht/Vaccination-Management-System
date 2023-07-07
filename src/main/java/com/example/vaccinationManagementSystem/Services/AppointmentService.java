package com.example.vaccinationManagementSystem.Services;

import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.AppointmentRequestDto;
import com.example.vaccinationManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccinationManagementSystem.Exceptions.UserNotFoundException;
import com.example.vaccinationManagementSystem.Models.Appointment;
import com.example.vaccinationManagementSystem.Models.Doctor;
import com.example.vaccinationManagementSystem.Models.User;
import com.example.vaccinationManagementSystem.Models.VaccinationCenter;
import com.example.vaccinationManagementSystem.Repository.AppointmentRepository;
import com.example.vaccinationManagementSystem.Repository.DoctorRepository;
import com.example.vaccinationManagementSystem.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.print.SimpleDoc;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    private JavaMailSender emailSender;
    public String bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFound {
        Optional<User> userOptional = userRepository.findById(appointmentRequestDto.getUserId());
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(userOptional.isEmpty()){
            throw new DoctorNotFound("Doctor Not Found");
        }
        User user = userOptional.get();
        Doctor doctor = doctorOptional.get();

        VaccinationCenter vaccinationCenter = doctor.getVaccinationCenter();
        if(vaccinationCenter.getDoseCapacity() > 0){
            Appointment appointment = new Appointment();
            appointment.setUser(user);
            appointment.setDoctor(doctor);
            appointment.setAppointmentDate(appointmentRequestDto.getAppointmentDate());
            appointment.setAppointmentTime(appointmentRequestDto.getAppointmentTime());

            //Saving this before so that we can primary key of appointment
            //If we don't save both doctor and user table will generate 2 appointment ID's
            appointmentRepository.save(appointment);

            doctor.getAppointmentList().add(appointment);
            user.getAppointmentList().add(appointment);

            doctorRepository.save(doctor);
            userRepository.save(user);

            //Mail Sender
            String body = "Hi, "+user.getName()+"\n"+
                    "You have successfully booked an appointment on "+appointment.getAppointmentDate()+
                    "at "+appointment.getAppointmentTime()+
                    "with Doctor "+doctor.getName()+
                    "\n" +"Please reach at this center "+doctor.getVaccinationCenter().getAddress()+"\n"+
                    "Please wear mask before enter in the center";
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("spring.test750@gmail.com");
            simpleMailMessage.setTo(user.getEmail());
            simpleMailMessage.setSubject("Appointment Confirmed");
            simpleMailMessage.setText(body);

            emailSender.send(simpleMailMessage);

            return "Appointment booked successfully";
        }
        return "No dose available at: " + vaccinationCenter.getAddress();
    }
}
