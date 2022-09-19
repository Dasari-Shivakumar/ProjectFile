package com.mindtree.Patient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Patient.Entity.Patient;
import com.mindtree.Patient.Service.PatientService;

@CrossOrigin
@RestController
public class PatinetController {
	@Autowired
	private PatientService patientService;
	 
	@PostMapping("/patient")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}
	@GetMapping("/patient/{id}")
	public Patient getPatientById(@PathVariable long id){
		return patientService.getPatientById(id);
	}
	
	@PutMapping("/patient/{id}/{docName}")
	public Patient assignDocId(@PathVariable long id,@PathVariable String docName){
		return patientService.assignDocId(id,docName);
	}
	
}
