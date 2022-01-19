package com.parth.hospital.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parth.hospital.application.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
