package com.parth.hospital.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Patients")
public class Patient {

	@Id
	@Column(name = "id")
	private long patientId;
	
	@Column(name = "name")
	private String patientName;
	
	@Column(name = "age")
	private int age;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visited_doctor", referencedColumnName = "id")
	//@JsonIgnore
	//@JsonManagedReference
	//@JsonBackReference
	private Doctor doctor;
	
	@Column(name = "date_of_visit")
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private String dateOfVisit;
	
	@Column(name = "prescription")
	private String prescription = "";
	
	public Patient() {
		super();
	}

	public Patient(long patientId, String patientName, int age, Doctor doctor, String dateOfVisit,
			String prescription) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.doctor = doctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
}
