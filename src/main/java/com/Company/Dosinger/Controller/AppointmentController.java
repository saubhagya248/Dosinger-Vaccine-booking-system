package com.Company.Dosinger.Controller;

import com.Company.Dosinger.DTO.Request.AppointmentRequestDto;
import com.Company.Dosinger.DTO.Response.AppointmentResponseDto;
import com.Company.Dosinger.Exception.DoctorNotFoundException;
import com.Company.Dosinger.Exception.UserNotFoundException;
import com.Company.Dosinger.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto){
        try{
            AppointmentResponseDto responseDto = appointmentService.bookAppointment(appointmentRequestDto);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (DoctorNotFoundException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (UserNotFoundException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
