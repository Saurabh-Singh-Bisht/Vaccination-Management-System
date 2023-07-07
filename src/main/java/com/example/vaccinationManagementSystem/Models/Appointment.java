package com.example.vaccinationManagementSystem.Models;

import jakarta.persistence.*;
import lombok.CustomLog;
import lombok.Data;

import javax.print.Doc;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date appointmentDate;
    private LocalTime appointmentTime;
    @ManyToOne
    @JoinColumn
    private Doctor doctor;
    @ManyToOne
    @JoinColumn
    private User user;
}
