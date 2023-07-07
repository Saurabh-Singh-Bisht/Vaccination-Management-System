package com.example.vaccinationManagementSystem.Exceptions;

public class CenterNotFound extends RuntimeException{
    public CenterNotFound(String msg){
        super(msg);
    }
}
