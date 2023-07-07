package com.example.vaccinationManagementSystem.Services;

import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.AssociateDoctorDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.AppointmentResponseDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.DoctorResponseDto;
import com.example.vaccinationManagementSystem.Enums.Gender;
import com.example.vaccinationManagementSystem.Exceptions.CenterNotFound;
import com.example.vaccinationManagementSystem.Exceptions.DoctorAlreadyAddedException;
import com.example.vaccinationManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccinationManagementSystem.Exceptions.EmailIdEmptyException;
import com.example.vaccinationManagementSystem.Models.Appointment;
import com.example.vaccinationManagementSystem.Models.Doctor;
import com.example.vaccinationManagementSystem.Models.VaccinationCenter;
import com.example.vaccinationManagementSystem.Repository.AppointmentRepository;
import com.example.vaccinationManagementSystem.Repository.DoctorRepository;
import com.example.vaccinationManagementSystem.Repository.VaccinationCenterRepository;
import com.example.vaccinationManagementSystem.Transformers.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;
    public String add(Doctor doctor) throws EmailIdEmptyException, DoctorAlreadyAddedException {
        if(doctor.getEmailId()==null){
            throw new EmailIdEmptyException("Please Enter your Email Id");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId()) != null){
            throw new DoctorAlreadyAddedException("Email ID already added");
        }
        doctorRepository.save(doctor);
        return "Doctor added successfully";
    }

    public String associateDoctor(AssociateDoctorDto associateDoctorDto) throws DoctorNotFound, CenterNotFound {
        Integer doctorID = associateDoctorDto.getDocId();
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorID);
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFound("Doctor Not Present");
        }
        Integer centerId = associateDoctorDto.getCenterId();
        Optional<VaccinationCenter> centerOptional = vaccinationCenterRepository.findById(centerId);
        if(centerOptional.isEmpty()){
            throw new CenterNotFound("Center Not Present");
        }
        Doctor doctor = doctorOptional.get();
        VaccinationCenter vaccinationCenter = centerOptional.get();
        doctor.setVaccinationCenter(vaccinationCenter);

        vaccinationCenter.getDoctorList().add(doctor);

        vaccinationCenterRepository.save(vaccinationCenter);
        return "Doctor has been associated to the center";
    }

    public String getRatioOfMaleAndFemaleDoctors() {
        int males = doctorRepository.getMaleCount();
        int females = doctorRepository.getFemalesCount();
        return males + ":" + females;
    }

    public List<DoctorResponseDto> getListOfDoctorsAtCenter(int centerId) {
        List<Doctor> doctorList = doctorRepository.findAll();
        List<DoctorResponseDto> doctorResponseDtos = DoctorTransformer.doctorListToDoctorResponseDto(doctorList, centerId);
        return doctorResponseDtos;
    }

    public List<DoctorResponseDto> getListOfMaleDoctorAtCenter(int centerId) {
        List<Doctor> doctorList = doctorRepository.getMaleDoctor();
        List<DoctorResponseDto> doctorResponseDtos = DoctorTransformer.doctorListToDoctorResponseDto(doctorList, centerId);
        return doctorResponseDtos;
    }

    public List<DoctorResponseDto> getListOfFemaleDoctorAtCenter(int centerId) {
        List<Doctor> doctorList = doctorRepository.getFemalesDoctor();
        List<DoctorResponseDto> doctorResponseDtos = DoctorTransformer.doctorListToDoctorResponseDto(doctorList, centerId);
        return doctorResponseDtos;
    }

    public List<AppointmentResponseDto> getDoctorAllAppointments(int doctorId) {
        List<Appointment> appointmentList = appointmentRepository.getAppointmentList(doctorId);
        List<AppointmentResponseDto> appointmentResponseDtos = DoctorTransformer.appointmentToAppointmentResponseDto(appointmentList);
        return appointmentResponseDtos;
    }
}
