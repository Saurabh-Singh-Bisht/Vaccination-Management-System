package com.example.vaccinationManagementSystem.Transformers;

import com.example.vaccinationManagementSystem.DTOs.ResponseDTOs.UserResponseDto;
import com.example.vaccinationManagementSystem.Models.User;

public class UserTransformer {
    public static UserResponseDto convertUserToUserResponseDto(User user){
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .gender(user.getGender())
                .mobileNo(user.getMobileNo())
                .build();
        return userResponseDto;
    }
}
