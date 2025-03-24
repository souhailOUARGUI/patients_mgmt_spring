package com.example.patients_mgmt_spring;

import com.example.patients_mgmt_spring.entities.Patient;
import com.example.patients_mgmt_spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientsMgmtSpringApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientsMgmtSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//	Patient patient = new Patient();
//	patient.setNom("Mohamed");
//	patient.setDateNaissance(new Date());
//	patient.setMalade(true);
//	patient.setScore(23);
//
//	Patient patient2 = new Patient(null,"yahya",new Date(),false,123 );
//
//	//en utilisant builder
//	Patient patient3  = Patient.builder().nom("souhail").dateNaissance(new Date()).malade(true).score(15).build();

		patientRepository.save(Patient.builder().nom("yahya").dateNaissance(new Date()).malade(true).score(10).build());
		patientRepository.save(Patient.builder().nom("souhail").dateNaissance(new Date()).malade(false).score(123).build());
		patientRepository.save(Patient.builder().nom("mohamed").dateNaissance(new Date()).malade(true).score(23).build());

	}
}
