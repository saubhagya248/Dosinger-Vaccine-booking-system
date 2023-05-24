package com.Company.Dosinger.Transformer;

import com.Company.Dosinger.DTO.Request.UserRequestDto;
import com.Company.Dosinger.DTO.Response.UserResponseDto;
import lombok.experimental.UtilityClass;
import com.Company.Dosinger.Model.User;

public class UserTransformer {

    public static User RequestDtoToUser(UserRequestDto requestDto){
        return User.builder().name(requestDto.getName())
                .age(requestDto.getAge())
                .email(requestDto.getEmailId())
                .mobile(requestDto.getMobile())
                .gender(requestDto.getGender())
                .build();
    }

    public static UserResponseDto UserToResponseDto(User user){
        return UserResponseDto.builder().name(user.getName())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .build();
    }

    //Overloaded method
    public static UserResponseDto UserToResponseDto(User user,String message){
        return UserResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .message(message)
                .build();
    }
}
