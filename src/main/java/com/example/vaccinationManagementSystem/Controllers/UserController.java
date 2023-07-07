package com.example.vaccinationManagementSystem.Controllers;

import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.UpdateEmailDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.UserResponseDto;
import com.example.vaccinationManagementSystem.Models.User;
import com.example.vaccinationManagementSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/vaccinationDate")
    public ResponseEntity<Date> getVaccinationDate(@RequestParam Integer userId){
        return new ResponseEntity<>(userService.getVaccinationDate(userId), HttpStatus.FOUND);
    }
    @PutMapping("/updateEmail")
    public ResponseEntity<String> updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return new ResponseEntity<>(userService.updateEmail(updateEmailDto), HttpStatus.CREATED);
    }
    @GetMapping("/getUserByEmailId")
    public UserResponseDto getUserByEmailId(@RequestParam String email){
        return userService.getUserByEmail(email);
    }
}
