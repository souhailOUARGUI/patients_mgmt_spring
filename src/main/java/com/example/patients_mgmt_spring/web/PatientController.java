package com.example.patients_mgmt_spring.web;


import com.example.patients_mgmt_spring.entities.Patient;
import com.example.patients_mgmt_spring.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page ,
                        @RequestParam(value = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword ) {
        Page<Patient> patientPage  = patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

}
