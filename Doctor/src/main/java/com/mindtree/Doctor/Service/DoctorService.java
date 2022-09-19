package com.mindtree.Doctor.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mindtree.Doctor.Entity.Doctor;

public interface DoctorService {

	ResponseEntity<Doctor> saveDoctor(Doctor doctor);

//	List<String> getDoctors();

	List<Doctor> getAllDoctors();

	Doctor getDoctorByName(String docName);

	Doctor getDoctorById(long id);

	

}
