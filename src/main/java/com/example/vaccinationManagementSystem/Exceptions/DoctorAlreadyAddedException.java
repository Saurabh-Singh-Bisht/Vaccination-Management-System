package com.example.vaccinationManagementSystem.Exceptions;

public class DoctorAlreadyAddedException extends RuntimeException{
    public DoctorAlreadyAddedException(String msg){
        super(msg);
    }
}
