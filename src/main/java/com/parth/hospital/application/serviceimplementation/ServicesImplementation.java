package com.parth.hospital.application.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parth.hospital.application.entity.Doctor;
import com.parth.hospital.application.entity.Patient;
import com.parth.hospital.application.exception.CustomException;
import com.parth.hospital.application.repository.DoctorRepository;
import com.parth.hospital.application.repository.PatientRepository;
import com.parth.hospital.application.service.Services;

@Service
public class ServicesImplementation implements Services {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public List<Patient> displayAllPatients() throws CustomException {
		List<Patient> patients = patientRepository.findAll();
		if(patients.isEmpty())
			throw new CustomException("No Patients present in the database.");
		else
		return patients;
	}

	@Override
	public Patient displayPatientById(long patientId) throws CustomException {
		Optional<Patient> patient = patientRepository.findById(patientId);
		if(patient.isEmpty())
			throw new CustomException("No Patient with Patient ID "+patientId+" present in the database.");
		else
		return patient.get();
	}

	@Override
	public String createPatient(Patient patient) {
		patientRepository.save(patient);
		return "Patient added Successfully to the Database.";
	}

	@Override
	public List<Doctor> displayAllDoctors() throws CustomException {
		List<Doctor> doctors = doctorRepository.findAll();
		if(doctors.isEmpty())
			throw new CustomException("No Doctors present in the database.");
		else
		return doctors;
	}

	@Override
	public String createDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
		return "Doctor added successfully to the database.";
	}

	@Override
	public int numberOfPatientsAttended(long doctorId) throws CustomException {
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		if(doctor.isEmpty())
			throw new CustomException("No Doctor with Doctor ID "+doctorId+" present in the Database.");
		else {
			List<Patient> patients = doctor.get().getPatients();
			return patients.size();
		}
	}

}
