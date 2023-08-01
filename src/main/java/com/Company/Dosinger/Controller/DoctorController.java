package com.Company.Dosinger.Controller;


import com.Company.Dosinger.DTO.Request.DoctorRequestDto;
import com.Company.Dosinger.DTO.Response.DoctorResponseDto;
import com.Company.Dosinger.Exception.CenterDoesNotExistException;
import com.Company.Dosinger.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto requestDto){
        try{
            DoctorResponseDto responseDto = doctorService.addDoctor(requestDto);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (CenterDoesNotExistException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
