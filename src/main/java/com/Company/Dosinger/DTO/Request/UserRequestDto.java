package com.Company.Dosinger.DTO.Request;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.Company.Dosinger.Enum.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;
    int age;
    String emailId;
    String mobile;
    Gender gender;

}
