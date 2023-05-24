package com.Company.Dosinger.DTO.Response;

import com.Company.Dosinger.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponseDto {
    String name;

    String location;

    CenterType centerType;
}
