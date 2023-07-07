package com.example.vaccinationManagementSystem.Exceptions;

public class DoctorNotFound extends RuntimeException{
    public DoctorNotFound(String msg){
        super(msg);
    }
}
