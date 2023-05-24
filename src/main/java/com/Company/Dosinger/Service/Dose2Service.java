package com.Company.Dosinger.Service;

import com.Company.Dosinger.Enum.VaccineType;
import com.Company.Dosinger.Model.Dose2;
import com.Company.Dosinger.Model.User;

public interface Dose2Service {
    Dose2 createDose2(User user, VaccineType vaccineType);
}
