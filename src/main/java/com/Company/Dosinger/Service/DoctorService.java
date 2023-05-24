package com.Company.Dosinger.Service;


import com.Company.Dosinger.DTO.Request.DoctorRequestDto;
import com.Company.Dosinger.DTO.Response.DoctorResponseDto;
import com.Company.Dosinger.Exception.CenterDoesNotExistException;

public interface DoctorService {

    DoctorResponseDto addDoctor(DoctorRequestDto requestDto) throws CenterDoesNotExistException;
}
