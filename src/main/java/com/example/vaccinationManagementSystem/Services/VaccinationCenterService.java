package com.example.vaccinationManagementSystem.Services;

import com.example.vaccinationManagementSystem.Exceptions.VaccinationAddressNotFound;
import com.example.vaccinationManagementSystem.Models.VaccinationCenter;
import com.example.vaccinationManagementSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String addVaccinationCenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {
        if(vaccinationCenter.getAddress() == null){
            throw new VaccinationAddressNotFound("Vaccination address is empty");
        }
        vaccinationCenterRepository.save(vaccinationCenter);
        return "Vaccination center added at location:" + vaccinationCenter.getAddress();
    }
}
