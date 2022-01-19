package com.parth.hospital.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parth.hospital.application.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
