package com.mindtree.Doctor.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.Doctor.Entity.Doctor;
import com.mindtree.Doctor.Repository.DoctorRepo;

@Service
public class DoctorServiceImp implements DoctorService{
	@Autowired
	private DoctorRepo doctorRepo;
	@Override
	public ResponseEntity<Doctor> saveDoctor(Doctor doctor) {
		
		return new ResponseEntity<Doctor>(doctorRepo.save(doctor),HttpStatus.ACCEPTED);
	}

//	@Override
//	public List<String> getDoctors() {
//		
//		return doctorRepo.findAllByName();
//	}

	@Override
	public List<Doctor> getAllDoctors() {
		
		return doctorRepo.findAll();
	}

	@Override
	public Doctor getDoctorByName(String docName) {
		
		return doctorRepo.getDoctorByName(docName);
	}

	@Override
	public Doctor getDoctorById(long id) {
		
		return doctorRepo.findById(id).get();
	}

	

}
