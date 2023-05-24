package com.Company.Dosinger.Service;

import com.Company.Dosinger.DTO.Request.UserRequestDto;
import com.Company.Dosinger.DTO.Response.UserResponseDto;

public interface UserService {

    public UserResponseDto addUser(UserRequestDto user);

    public UserResponseDto getUser(String email);

    UserResponseDto updateName(String mobile,String name);
}
