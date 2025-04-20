package com.example.patients_mgmt_spring.web;


import com.example.patients_mgmt_spring.entities.Patient;
import com.example.patients_mgmt_spring.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model){
        Page<Patient> patientPage  = patientRepository.findAll(PageRequest.of(0,4));
        model.addAttribute("listPatients",patientPage.getContent());
        return "patients";
    }

}
