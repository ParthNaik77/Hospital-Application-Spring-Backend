package com.parth.hospital.application.service;

import java.util.List;

import com.parth.hospital.application.entity.Doctor;
import com.parth.hospital.application.entity.Patient;
import com.parth.hospital.application.exception.CustomException;

public interface Services {

	//Patient Services
	public List<Patient> displayAllPatients() throws CustomException;
	
	public Patient displayPatientById(long patientId) throws CustomException;
	
	public String createPatient(Patient patient);
	
	//Doctor Services
	public List<Doctor> displayAllDoctors() throws CustomException;
	
	public String createDoctor(Doctor doctor);
	
	public int numberOfPatientsAttended(long doctorId) throws CustomException;
}
