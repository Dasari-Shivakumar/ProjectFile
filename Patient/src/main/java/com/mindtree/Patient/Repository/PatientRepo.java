package com.mindtree.Patient.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.Patient.Entity.Patient;


@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{
	@Query(value = "SELECT Count(p.id) FROM patient p WHERE p.visited_doctor=?1",nativeQuery = true)
	int countTotal(String name);

	
	

}
