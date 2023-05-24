package com.Company.Dosinger.Transformer;

import com.Company.Dosinger.DTO.Request.DoctorRequestDto;
import com.Company.Dosinger.DTO.Response.CenterResponseDto;
import com.Company.Dosinger.DTO.Response.DoctorResponseDto;
import com.Company.Dosinger.Model.Doctor;

public class DoctorTransformer {

    public static Doctor RequestDtoToDoctor(DoctorRequestDto requestDto){
        return Doctor.builder()
                .age(requestDto.getAge())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .mobile(requestDto.getMobile())
                .gender(requestDto.getGender())
                .build();
    }

    public static DoctorResponseDto DoctorToResponseDto(Doctor doctor){

        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(doctor.getVaccinationCenter());

        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .email(doctor.getEmail())
                .mobile(doctor.getMobile())
                .centerResponseDto(centerResponseDto)
                .build();
    }
}
