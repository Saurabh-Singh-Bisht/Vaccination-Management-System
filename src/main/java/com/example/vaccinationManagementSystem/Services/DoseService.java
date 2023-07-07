package com.example.vaccinationManagementSystem.Services;

import com.example.vaccinationManagementSystem.Models.Dose;
import com.example.vaccinationManagementSystem.Models.User;
import com.example.vaccinationManagementSystem.Models.VaccinationCenter;
import com.example.vaccinationManagementSystem.Repository.DoseRepository;
import com.example.vaccinationManagementSystem.Repository.UserRepository;
import com.example.vaccinationManagementSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String giveDose1(String doseId, Integer userId,  Integer centerId) {
        User user = userRepository.findById(userId).get();

        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.getById(centerId);
        vaccinationCenter.setDoseCapacity(vaccinationCenter.getDoseCapacity()-1);
        vaccinationCenterRepository.save(vaccinationCenter);

        //An Entity of that model has been created
        //This entity will be saved in database
        Dose dose = new Dose();
        //setting it's attributes
        dose.setDoseId(doseId);
        dose.setUser(user);
        //setting the child object in that corresponding
        user.setDose(dose);
        userRepository.save(user);
        //Child will automatically get saved because of cascading effect
        return "Dose1 Injected Successfully";
    }
}
