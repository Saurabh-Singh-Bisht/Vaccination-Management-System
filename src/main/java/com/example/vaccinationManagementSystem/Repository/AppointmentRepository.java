package com.example.vaccinationManagementSystem.Repository;

import com.example.vaccinationManagementSystem.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value = "select * from appointments where doctor_doc_id = :doctorId", nativeQuery = true)
    List<Appointment> getAppointmentList(int doctorId);
}
