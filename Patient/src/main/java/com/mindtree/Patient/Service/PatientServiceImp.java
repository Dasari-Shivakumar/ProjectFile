package com.mindtree.Patient.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;
import com.mindtree.Patient.Exception.ResourceNotFoundException;

import com.mindtree.Patient.Entity.Patient;

import com.mindtree.Patient.Repository.PatientRepo;
import com.mindtree.Patient.Vo.Doctor;

@Service
public class PatientServiceImp implements PatientService{
	@Autowired
	private PatientRepo patientRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public Patient savePatient(Patient patient) {

		Patient savedPatient=new Patient();
		savedPatient=patientRepo.save(patient);
		 
		ResponseEntity<Doctor> d= restTemplate.getForEntity("http://localhost:8081/"+savedPatient.getVisitedDoctor(), Doctor.class);
		Doctor doc=d.getBody();
		int c=patientRepo.countTotal(doc.getName());
		System.out.println("Hello"+c);
		doc.setNumberOfPatients(patientRepo.countTotal(doc.getName()));
		
		@SuppressWarnings("unused")
		ResponseEntity<Doctor> savedDoctor=restTemplate.postForEntity("http://localhost:8081/"+ "doctors",doc, Doctor.class);
		return patientRepo.save(patient);
		
	}

	@Override
	public Patient getPatientById(long id) {
		
			java.util.Optional<Patient> patient=patientRepo.findById(id);
			Patient savedPatient=new Patient();
			if(patient.isPresent()) {
				savedPatient=patient.get();
			}
			else 
			{
				throw new ResourceNotFoundException("Patient", "id", savedPatient);
			}
			return savedPatient;
	}

	@Override
	public Patient assignDocId(long id, String docName) {
		Optional<Patient> patient=patientRepo.findById(id);
		Patient savedPatient=new Patient();
		if(patient.isPresent()) {
			savedPatient=patient.get();
		}
		savedPatient.setVisitedDoctor(docName);
		return patientRepo.save(savedPatient);

	}

	}

