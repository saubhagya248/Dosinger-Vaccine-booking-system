package com.Company.Dosinger.Controller;

import com.Company.Dosinger.DTO.Request.UserRequestDto;
import com.Company.Dosinger.DTO.Response.UserResponseDto;
import com.Company.Dosinger.Exception.UserNotFoundException;
import com.Company.Dosinger.Service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/auth")
    public ResponseEntity<String> authenticate(){
        return ResponseEntity.ok("Authenticated");
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDto user){
        UserResponseDto responseDto = userService.addUser(user);
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    // find by emailid
    @RequestMapping("/get-by-email")
    public ResponseEntity getUser(@RequestParam String email){
        try{
            UserResponseDto responseDto = userService.getUser(email);
            return new ResponseEntity(responseDto,HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // update the name of the user mobno
    @PutMapping("/update-name")
    public ResponseEntity updateName(@RequestParam String mobile,@RequestParam String name){
        try{
            UserResponseDto responseDto = userService.updateName(mobile,name);
            return new ResponseEntity<>(responseDto,HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // all the users who have not taken even a single dose

    // all users who have taken does1 but not dose2

    // all users who are fully vaccinated.

    // all male users who have not taken even a single vaccine

    // all female users who are fully vaccinated
}
