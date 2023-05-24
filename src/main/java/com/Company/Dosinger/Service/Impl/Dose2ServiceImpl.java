package com.Company.Dosinger.Service.Impl;

import com.Company.Dosinger.Enum.VaccineType;
import com.Company.Dosinger.Model.Dose2;
import com.Company.Dosinger.Model.User;
import com.Company.Dosinger.Service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2ServiceImpl implements Dose2Service {

    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {
        return Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}
