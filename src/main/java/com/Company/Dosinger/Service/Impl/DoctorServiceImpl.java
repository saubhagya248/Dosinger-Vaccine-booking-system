package com.Company.Dosinger.Service.Impl;

import com.Company.Dosinger.DTO.Request.DoctorRequestDto;
import com.Company.Dosinger.DTO.Response.DoctorResponseDto;
import com.Company.Dosinger.Exception.CenterDoesNotExistException;
import com.Company.Dosinger.Model.Doctor;
import com.Company.Dosinger.Model.VaccinationCenter;
import com.Company.Dosinger.Repository.CenterRepository;
import com.Company.Dosinger.Repository.DoctorRepository;
import com.Company.Dosinger.Service.DoctorService;
import com.Company.Dosinger.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    CenterRepository centerRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto requestDto) throws CenterDoesNotExistException {

        Optional<VaccinationCenter> centerOptional = centerRepository.findById(requestDto.getCenterId());

        if(centerOptional.isEmpty()) throw new CenterDoesNotExistException("Center Id is invalid!");

        //if the center id is valid then move ahead
        //get the center
       VaccinationCenter center = centerOptional.get();

       //convert dto to entity
        Doctor doctor = DoctorTransformer.RequestDtoToDoctor(requestDto);
        doctor.setVaccinationCenter(center);

        //add the doctor to the current list of center
        center.getDoctors().add(doctor);

        //as we are saving the parent then child(doctor) will also be saved
        centerRepository.save(center);

        //prepare for the response dto
        return DoctorTransformer.DoctorToResponseDto(doctor);
    }
}
