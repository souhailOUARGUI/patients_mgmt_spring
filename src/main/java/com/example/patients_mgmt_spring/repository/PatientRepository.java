package com.example.patients_mgmt_spring.repository;

import com.example.patients_mgmt_spring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {

}
