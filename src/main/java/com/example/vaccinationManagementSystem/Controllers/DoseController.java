package com.example.vaccinationManagementSystem.Controllers;

import com.example.vaccinationManagementSystem.Services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
    @PostMapping("/giveDose1")
    public String giveDose1(@RequestParam String doseId,@RequestParam Integer userId,@RequestParam Integer centerId){
        return doseService.giveDose1(doseId, userId, centerId);
    }
}
