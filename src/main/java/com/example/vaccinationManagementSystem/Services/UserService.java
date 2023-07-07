package com.example.vaccinationManagementSystem.Services;

import com.example.vaccinationManagementSystem.DTOs.RequestDTOs.UpdateEmailDto;
import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.UserResponseDto;
import com.example.vaccinationManagementSystem.Models.Dose;
import com.example.vaccinationManagementSystem.Models.User;
import com.example.vaccinationManagementSystem.Repository.UserRepository;
import com.example.vaccinationManagementSystem.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user){
        user = userRepository.save(user);
        return user;
    }

    public Date getVaccinationDate(Integer userId) {
        User user = userRepository.findById(userId).get();
        Dose dose = user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userId = updateEmailDto.getUserId();
        User user = userRepository.findById(userId).get();
        //Modified Entity
        user.setEmail(updateEmailDto.getNewEmailId());
        userRepository.save(user);
        return "Email Updated Successfully:" + updateEmailDto.getNewEmailId();
    }
    public UserResponseDto getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        UserResponseDto userResponseDto = UserTransformer.convertUserToUserResponseDto(user);
        return userResponseDto;
    }
}
