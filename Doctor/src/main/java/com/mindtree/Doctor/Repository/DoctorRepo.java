package com.mindtree.Doctor.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.Doctor.Entity.Doctor;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
//	@Query(value = "SELECT d.name FROM doctor d",nativeQuery = true)
//	List<String> findAllByName();
	
	@Query(value = "SELECT * FROM doctor d WHERE d.name=?1",nativeQuery = true)
	Doctor getDoctorByName(String docName);

}
