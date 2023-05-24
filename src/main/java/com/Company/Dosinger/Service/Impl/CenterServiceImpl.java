package com.Company.Dosinger.Service.Impl;

import com.Company.Dosinger.DTO.Request.CenterRequestDto;
import com.Company.Dosinger.DTO.Response.CenterResponseDto;
import com.Company.Dosinger.Model.VaccinationCenter;
import com.Company.Dosinger.Repository.CenterRepository;
import com.Company.Dosinger.Service.CenterService;
import com.Company.Dosinger.Transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto requestDto) {

        VaccinationCenter center = centerRepository.save(CenterTransformer.requestDtoToCenter(requestDto));
        return CenterTransformer.CenterToResponseDto(center);

    }
}
