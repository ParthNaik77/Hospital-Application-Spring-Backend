package com.parth.hospital.application.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "Doctors")
public class Doctor {

	@Id
	@Column(name = "id")
	private long doctorId;
	
	@Column(name = "name")
	private String doctorName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "specialist")
	private String specialist;
	
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	//@JsonBackReference
	//@JsonManagedReference
	private List<Patient> patients;

	
	public Doctor() {
		super();
	}

	public Doctor(long doctorId, String doctorName, int age, String gender, String specialist, List<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
		this.patients = patients;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
