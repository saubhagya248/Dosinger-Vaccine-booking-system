package com.Company.Dosinger.DTO.Response;

import com.Company.Dosinger.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponseDto {

    String name;

    String email;
    String mobile;
    String message;
}
