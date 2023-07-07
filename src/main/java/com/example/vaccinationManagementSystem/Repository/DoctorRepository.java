package com.example.vaccinationManagementSystem.Repository;

import com.example.vaccinationManagementSystem.Enums.Gender;
import com.example.vaccinationManagementSystem.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByEmailId(String email);

    @Query(value = "select count(*) from doctor where gender = \"MALE\"", nativeQuery = true)
    int getMaleCount();

    @Query(value = "select count(*) from doctor where gender = \"FEMALE\"", nativeQuery = true)
    int getFemalesCount();

    @Query(value = "select * from doctor where gender = \"MALE\"", nativeQuery = true)
    List<Doctor> getMaleDoctor();

    @Query(value = "select * from doctor where gender = \"FEMALE\"", nativeQuery = true)
    List<Doctor> getFemalesDoctor();
}
