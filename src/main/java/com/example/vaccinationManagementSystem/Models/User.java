package com.example.vaccinationManagementSystem.Models;

import com.example.vaccinationManagementSystem.Enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Used to generate values
    private int userId;
    @Column(name = "user_name")
    private String name;
    private int age;
    @Column(unique = true)
    private String email;
    @Enumerated(value = EnumType.STRING)//User to store ENUM type in DB as a STRING
    private Gender gender;
    private String mobileNo;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Dose dose;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();
}
