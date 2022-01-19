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

import com.parth.hospital.application.entity.Doctor;
import com.parth.hospital.application.exception.CustomException;
import com.parth.hospital.application.service.Services;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

	@Autowired
	private Services services;
	
	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors() throws CustomException {
		return services.displayAllDoctors();
	}
	
	@PostMapping("/postDoctor")
	public String postDoctor(@RequestBody Doctor doctor) {
		return services.createDoctor(doctor);
	}
	
	@GetMapping("/getNumberOfPatientsVisited/{doctorId}")
	public int getNumberOfPatientsAttended(@PathVariable int doctorId) throws CustomException {
		return services.numberOfPatientsAttended(doctorId);
	}
}
