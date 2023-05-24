package com.Company.Dosinger.Service;

import com.Company.Dosinger.Enum.VaccineType;
import com.Company.Dosinger.Model.Dose1;
import com.Company.Dosinger.Model.User;

public interface Dose1Service {

    public Dose1 createDose1(User user, VaccineType vaccineType);
}
