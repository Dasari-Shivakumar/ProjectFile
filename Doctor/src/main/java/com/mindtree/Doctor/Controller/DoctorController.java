package com.mindtree.Doctor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Doctor.Entity.Doctor;
import com.mindtree.Doctor.Service.DoctorService;

@RestController
@CrossOrigin
//@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	private  DoctorService doctorService;
	
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}
//	@GetMapping("/doctors")
//	public List<String> getDoctors(){
//		return doctorService.getDoctors();
//	}
	@GetMapping("/doctors/")
	public List<Doctor> getAllDoctors( ){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/doctors/{docName}/")
	public Doctor getDoctorByName(@PathVariable String docName) {
		return doctorService.getDoctorByName(docName);
	}
	
	@GetMapping("/doctors/{id}")
	public Doctor getDoctorById(@PathVariable long id) {
		return doctorService.getDoctorById(id);
	}
}
