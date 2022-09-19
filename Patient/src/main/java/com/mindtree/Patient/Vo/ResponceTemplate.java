package com.mindtree.Patient.Vo;

import com.mindtree.Patient.Entity.Patient;

public class ResponceTemplate {
	private Doctor doctor;
	private Patient[] patient;
	public ResponceTemplate(Doctor doctor, Patient[] patient) {
		super();
		this.doctor = doctor;
		this.patient = patient;
	}
	public ResponceTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient[] getPatient() {
		return patient;
	}
	public void setPatient(Patient[] patient) {
		this.patient = patient;
	}
}
