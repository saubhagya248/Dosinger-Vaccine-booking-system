package com.Company.Dosinger.Service;

import com.Company.Dosinger.DTO.Request.AppointmentRequestDto;
import com.Company.Dosinger.DTO.Response.AppointmentResponseDto;
import com.Company.Dosinger.Exception.DoctorNotFoundException;

public interface AppointmentService {

    public AppointmentResponseDto bookAppointment(AppointmentRequestDto requestDto) throws DoctorNotFoundException;
}
