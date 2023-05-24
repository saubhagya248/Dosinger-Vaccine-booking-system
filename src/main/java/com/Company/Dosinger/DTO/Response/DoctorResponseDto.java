package com.Company.Dosinger.DTO.Response;

import com.Company.Dosinger.Enum.Gender;
import com.Company.Dosinger.Model.VaccinationCenter;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDto {

    String name;
    String email;
    String mobile;
    CenterResponseDto centerResponseDto;
}
