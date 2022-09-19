package com.mindtree.Patient.Service;

import com.mindtree.Patient.Entity.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

	Patient getPatientById(long id);

	Patient assignDocId(long id, String docName);

}
