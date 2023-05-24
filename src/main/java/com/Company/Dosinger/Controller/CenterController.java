package com.Company.Dosinger.Controller;

import com.Company.Dosinger.DTO.Request.CenterRequestDto;
import com.Company.Dosinger.DTO.Response.CenterResponseDto;
import com.Company.Dosinger.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class CenterController {

    @Autowired
    CenterService centerService;
    @PostMapping("/add")
    public ResponseEntity addCenter(@RequestBody CenterRequestDto center){
        CenterResponseDto responseDto = centerService.addCenter(center);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


    // give the list of all doctors at a particular center(centerId)

    // give the list of all male doctors at a particular center(centerId)

    // give the list of all females doctors at a particular center(centerId)

    // give the list of all male doctors above age 40 at a particular center(centerId)

    // give all centers of a particular centerType
}
