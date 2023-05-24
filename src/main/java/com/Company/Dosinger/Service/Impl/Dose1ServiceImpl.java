package com.Company.Dosinger.Service.Impl;

import com.Company.Dosinger.Enum.VaccineType;
import com.Company.Dosinger.Model.Dose1;
import com.Company.Dosinger.Model.User;
import com.Company.Dosinger.Service.Dose1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {


    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {
        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();

    }
}
