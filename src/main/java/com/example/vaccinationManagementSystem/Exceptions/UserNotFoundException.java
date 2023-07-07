package com.example.vaccinationManagementSystem.Exceptions;

import com.example.vaccinationManagementSystem.Models.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
