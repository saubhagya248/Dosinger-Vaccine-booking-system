package com.Company.Dosinger.DTO.Response;

import com.Company.Dosinger.Enum.DoseNumber;
import com.Company.Dosinger.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {
    String appointmentNo;

    String userName;

    String doctorName;

    DoseNumber doseNo;
    Date dateOfAppointment;

    CenterResponseDto centerResponseDto;

    VaccineType vaccineType;

}
