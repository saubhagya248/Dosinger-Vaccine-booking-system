package com.Company.Dosinger.Service;

import com.Company.Dosinger.DTO.Request.CenterRequestDto;
import com.Company.Dosinger.DTO.Response.CenterResponseDto;
import org.springframework.stereotype.Service;

public interface CenterService {
    public CenterResponseDto addCenter(CenterRequestDto requestDto);
}
