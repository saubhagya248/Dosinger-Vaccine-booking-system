package com.Company.Dosinger.DTO.Request;

import com.Company.Dosinger.Enum.DoseNumber;
import com.Company.Dosinger.Enum.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {
    DoseNumber doseNo;
    int userId;
    int doctorId;

    VaccineType vaccineType;

}
