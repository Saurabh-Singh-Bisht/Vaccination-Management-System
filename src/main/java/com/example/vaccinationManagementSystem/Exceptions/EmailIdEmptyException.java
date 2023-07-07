package com.example.vaccinationManagementSystem.Exceptions;

public class EmailIdEmptyException extends RuntimeException{
    public EmailIdEmptyException(String msg){
        super(msg);
    }
}
