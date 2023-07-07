package com.example.vaccinationManagementSystem.Repository;

import com.example.vaccinationManagementSystem.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose, Integer>{
}
