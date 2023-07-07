package com.example.vaccinationManagementSystem.Repository;

import com.example.vaccinationManagementSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Just define function to execute:
    User findByEmail(String email);
}