package com.example.vaccinationManagementSystem.Exceptions;

public class VaccinationAddressNotFound extends RuntimeException{
    public VaccinationAddressNotFound(String msg){
        super(msg);
    }
}
