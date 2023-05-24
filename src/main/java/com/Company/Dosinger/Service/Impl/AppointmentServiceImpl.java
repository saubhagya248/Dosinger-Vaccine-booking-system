package com.Company.Dosinger.Service.Impl;

import com.Company.Dosinger.DTO.Request.AppointmentRequestDto;
import com.Company.Dosinger.DTO.Response.AppointmentResponseDto;
import com.Company.Dosinger.DTO.Response.CenterResponseDto;
import com.Company.Dosinger.Enum.DoseNumber;
import com.Company.Dosinger.Exception.DoctorNotFoundException;
import com.Company.Dosinger.Exception.UserNotFoundException;
import com.Company.Dosinger.Model.*;
import com.Company.Dosinger.Repository.DoctorRepository;
import com.Company.Dosinger.Repository.UserRepository;
import com.Company.Dosinger.Service.AppointmentService;
import com.Company.Dosinger.Service.Dose1Service;
import com.Company.Dosinger.Service.Dose2Service;
import com.Company.Dosinger.Transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    Dose1Service dose1Service;

    @Autowired
    Dose2Service dose2Service;

    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto requestDto) throws DoctorNotFoundException, UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(requestDto.getUserId());
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User id invalid!");
        }
        Optional<Doctor> doc = doctorRepository.findById(requestDto.getDoctorId());
        if(doc.isEmpty()){
            throw new DoctorNotFoundException("Doctor id invalid!");
        }

        User user = optionalUser.get();
        Doctor doctor = doc.get();

        if(requestDto.getDoseNo()== DoseNumber.DOSE1){
            Dose1 dose1 = dose1Service.createDose1(user,requestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }
        if(requestDto.getDoseNo()== DoseNumber.DOSE2){
            Dose2 dose2 = dose2Service.createDose2(user,requestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

        Appointment appointment = Appointment.builder()
                .appointmentId(String.valueOf(UUID.randomUUID()))
                .doseNumber(requestDto.getDoseNo())
                .user(user)
                .doctor(doctor)
                .build();



        user.getAppointments().add(appointment);
        User savedUser = userRepository.save(user);

        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);
        doctor.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);

        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(doctor.getVaccinationCenter());

        return AppointmentResponseDto.builder()
                .userName(savedUser.getName())
                .appointmentNo(appointment.getAppointmentId())
                .dateOfAppointment(savedAppointment.getAppointmentDate())
                .doctorName(doctor.getName())
                .centerResponseDto(centerResponseDto)
                .vaccineType(requestDto.getVaccineType())
                .build();
    }
}
