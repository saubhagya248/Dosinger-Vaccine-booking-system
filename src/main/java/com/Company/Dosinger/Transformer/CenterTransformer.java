package com.Company.Dosinger.Transformer;

import com.Company.Dosinger.DTO.Request.CenterRequestDto;
import com.Company.Dosinger.DTO.Response.CenterResponseDto;
import com.Company.Dosinger.Model.VaccinationCenter;

public class CenterTransformer {

    public static VaccinationCenter requestDtoToCenter(CenterRequestDto requestDto){
        return VaccinationCenter.builder()
                .name(requestDto.getName())
                .location(requestDto.getLocation())
                .centerType(requestDto.getCenterType())
                .build();
    }

    public static CenterResponseDto CenterToResponseDto(VaccinationCenter center){
        return CenterResponseDto.builder()
                .name(center.getName())
                .location(center.getLocation())
                .centerType(center.getCenterType())
                .build();
    }
}
