package com.Company.Dosinger.Service.Impl;


import com.Company.Dosinger.DTO.Request.UserRequestDto;
import com.Company.Dosinger.DTO.Response.UserResponseDto;
import com.Company.Dosinger.Exception.UserNotFoundException;
import com.Company.Dosinger.Repository.UserRepository;
import com.Company.Dosinger.Service.UserService;
import com.Company.Dosinger.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Company.Dosinger.Model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public UserResponseDto addUser(UserRequestDto user) {
        //dto to entity
        User saved = repository.save(UserTransformer.RequestDtoToUser(user));
        //entity to dto
        return UserTransformer.UserToResponseDto(saved,"Congrats! user with "+saved.getName()+" registered successfully");
    }

    @Override
    public UserResponseDto getUser(String email) throws UserNotFoundException{

        Optional<User> opt = repository.findByEmail(email);

        if(opt.isEmpty()) throw new UserNotFoundException("User with "+email+" not found");

        else {
            User user = opt.get();
            return UserTransformer.UserToResponseDto(user);
        }
    }

    @Override
    public UserResponseDto updateName(String mobile,String name) throws UserNotFoundException{
        Optional<User> opt = repository.findByMobile(mobile);
        UserResponseDto responseDto = new UserResponseDto();

        if(opt.isEmpty()) throw new UserNotFoundException("User with mobile "+mobile+" not found");
        else{
            repository.updateName(mobile,name);
            Optional<User> response = repository.findByMobile(mobile);
            if(response.isPresent()){
                responseDto = UserTransformer.UserToResponseDto(response.get(),"The name has been updated. New name is: "+response.get().getName());
            }
            return responseDto;
        }
    }


}
