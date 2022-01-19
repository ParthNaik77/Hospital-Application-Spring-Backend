package com.parth.hospital.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parth.hospital.application.entity.Patient;
import com.parth.hospital.application.exception.CustomException;
import com.parth.hospital.application.service.Services;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private Services services;

	public PatientController(Services services) {
		super();
		this.services = services;
	}

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() throws CustomException {
		return services.displayAllPatients();
	}
	
	@GetMapping("/getPatientById/{patientId}")
	public Patient getPatientById(@PathVariable long patientId) throws CustomException {
		return services.displayPatientById(patientId);
	}
	
	@PostMapping("/postPatient")
	public String postPatient(@RequestBody Patient patient) {
		return services.createPatient(patient);
	}
}
